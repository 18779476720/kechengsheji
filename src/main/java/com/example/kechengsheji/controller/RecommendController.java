package com.example.kechengsheji.controller;

import antlr.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.example.kechengsheji.dao.DeliverinfoDao;
import com.example.kechengsheji.dao.RecruitinfoDao;
import com.example.kechengsheji.dao.ScoreinfoDao;
import com.example.kechengsheji.dao.dto.ApiResult;
import com.example.kechengsheji.dao.enums.XKHResponseCodeEnum;
import com.example.kechengsheji.dao.tool.AprioriMyself;
import com.example.kechengsheji.model.*;
import com.example.kechengsheji.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.*;

/**
* @Description:    推荐算法java类
* @Author:          longhua.wang
* @CreateDate:     2019/5/4 12:01
* @UpdateUser:     longhua.wang
* @UpdateDate:     2019/5/4 12:01
*/

@Controller
@RequestMapping("/recommend")
public class RecommendController {
    @Autowired
    AccountService accountService;
    @Autowired
    StudentinfoService studentinfoService;
    @Autowired
    SchoolinfoService schoolinfoService;
    @Autowired
    BusinessinfoService businessinfoService;
    @Autowired
    DeliverinfoService deliverinfoService;
    @Autowired
    RecruitinfoService recruitinfoService;

    @Autowired
    DeliverinfoDao deliverinfoDao;

    @Autowired
    RecruitinfoDao recruitinfoDao;

    @Autowired
    ScoreinfoDao scoreinfoDao;

    //通过id查询详细
    @RequestMapping(value="/getRecommend",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult<?> getRecommend(HttpSession session) {
         Object id = session.getAttribute("id");
        Account account = accountService.getById((Integer) id);
        Studentinfo studentinfo = studentinfoService.getByName(account.getAccountname());
        //获取当前人的所有的投递
        Deliverinfo deliverinfo = new Deliverinfo();
        deliverinfo.setAccountId(account.getId());
        List<Deliverinfo> list = deliverinfoDao.list(deliverinfo);

        //小于3个会默认为刚注册用户，这里直接根据符合条件的数据进行流行度推荐
        if(list.size() < 3){
            //首先找出契合度
            //二级分类
            String studentHopeJob = studentinfo.getHopeJob();
            //一级分类
            String studentHopeJob1 = studentinfo.getHopeJob1();
            String StudentSex = studentinfo.getSex();
            Integer studentStartTime = studentinfo.getStartTime();
            Integer studentEndTime = studentinfo.getEndTime();

            Recruitinfo recruitinfo = new Recruitinfo();
            Recruitinfo recruitinfo1 = new Recruitinfo();
            recruitinfo.setNeedSex(StudentSex);
            //recruitinfo1假设数据量不够，通过recruitinfo1当选了二级菜单后放大区间二级选所有，一级选当前
            if("不限".equals(studentHopeJob1)){
                recruitinfo.setRecruitType(null);
                recruitinfo1.setRecruitType1(null);
            }else if(!"不限".equals(studentHopeJob1) && "不限".equals(studentHopeJob)){
                recruitinfo.setRecruitType1(studentHopeJob1);
                recruitinfo.setRecruitType(null);
                recruitinfo1.setRecruitType1(studentHopeJob1);
                recruitinfo1.setRecruitType(null);
            }else{
                recruitinfo.setRecruitType(studentHopeJob);
                recruitinfo1.setRecruitType1(studentHopeJob1);
                recruitinfo1.setRecruitType(null);
            }
            recruitinfo.setBeginTime(studentStartTime);
            recruitinfo.setOverTime(studentEndTime);
            List<Recruitinfo> recruitList = recruitinfoDao.list(recruitinfo);
            if(recruitList.size() <= 5){
                recruitList = recruitinfoDao.list(recruitinfo1);
            }

            //查平均分，没评价过得分数默认为3
            Integer[] recruitListParams = new Integer[recruitList.size() + 1];
            HashMap<Integer, Integer> map = new HashMap<>();
            Map map1 = new HashMap();
            for(int i = 0; i < recruitList.size(); i ++){
                recruitListParams[i] = recruitList.get(i).getId();
            }
            //数据库查询出所有平均分
            List<AvgScore> avg = scoreinfoDao.selectAvgScore(recruitListParams);
            for(int i = 0; i < avg.size(); i ++){
                map.put(avg.get(i).getRecruitId(),1);
            }
            //最终实际所有平均分，包含所有  加入未被评分的职位
            List<AvgScore> avgList = new ArrayList<AvgScore>(Arrays.asList( new AvgScore[avg.size()]));
            Collections.copy(avgList,avg);
            for(int i = 0; i < recruitList.size(); i ++){
                if(!map.containsKey(recruitList.get(i).getId())){
                    AvgScore avgScore = new AvgScore();
                    avgScore.setRecruitId(recruitList.get(i).getId());
                    avgScore.setScoreNum((double) 3);
                    avgList.add(avgScore);
                }
            }
            Collections.sort(avgList);
            //只留下未投递和未招满的集合
            List<AvgScore> listCommend = new ArrayList<>();
            for(int i = 0; i < avgList.size(); i ++){
                //该职位已通过人数
                int hasOffer = deliverinfoService.selectHasDelivery(avgList.get(i).getRecruitId());
                //查询该招聘信息招聘人数
                int needNum = recruitinfoService.getById(avgList.get(i).getRecruitId()).getRecruitNum();
                //是否已经投递该职位
                int hasdelivery = deliverinfoService.selectIsHasDelivery((Integer) session.getAttribute("id"),avgList.get(i).getRecruitId());
                //未招聘满并且未投递过
                if(hasOffer < needNum && hasdelivery <= 0){
                    listCommend.add(avgList.get(i));
                }
            }
            List<AvgScore> listCommend1 = new ArrayList<>();
            if(listCommend.size() > 5){
                for(int i = 0; i < 5; i ++){
                    listCommend1.add(listCommend.get(i));
                }
            }
            //假设最终推荐的数量小于2，根据评分进行推荐
            if(listCommend.size() < 2){
                Recruitinfo recruitinfoNew = new Recruitinfo();
                List<Recruitinfo> recruitListNew = recruitinfoDao.list(recruitinfoNew);

                //查平均分，没评价过得分数默认为3
                Integer[] recruitListParamsNew = new Integer[recruitListNew.size() + 1];
                HashMap<Integer, Integer> mapNew = new HashMap<>();
                for(int i = 0; i < recruitListNew.size(); i ++){
                    recruitListParamsNew[i] = recruitListNew.get(i).getId();
                }
                //数据库查询出所有平均分
                List<AvgScore> avgNew = scoreinfoDao.selectAvgScore(recruitListParamsNew);
                Collections.sort(avgNew);

                //只留下未投递和未招满的集合
//                List<AvgScore> listCommendNew = new ArrayList<>();
                for(int i = 0; i < avgNew.size(); i ++){
                    //该职位已通过人数
                    int hasOffer = deliverinfoService.selectHasDelivery(avgNew.get(i).getRecruitId());
                    //查询该招聘信息招聘人数
                    int needNum = recruitinfoService.getById(avgNew.get(i).getRecruitId()).getRecruitNum();
                    //是否已经投递该职位
                    int hasdelivery = deliverinfoService.selectIsHasDelivery((Integer) session.getAttribute("id"),avgNew.get(i).getRecruitId());
                    //未招聘满并且未投递过
                    if(hasOffer < needNum && hasdelivery <= 0){
                        listCommend.add(avgNew.get(i));
                    }
                }
                if(listCommend.size() > 5){
                    for(int i = 0; i < 5; i ++){
                        listCommend1.add(listCommend.get(i));
                    }
                }

            }
            //从两种情况中只要前5个
            List<AvgScore> beforeResult = new ArrayList<>();
            if(listCommend1.size() > 0){
                for(int i = 0; i < listCommend1.size(); i ++){
                    beforeResult.add(listCommend1.get(i));
                }
            }else {
                for(int i = 0; i < listCommend.size(); i ++){
                    beforeResult.add(listCommend.get(i));
                }
            }
            List<RecruitinfoParams> resultList = new ArrayList<>();

            for(int i = 0; i < beforeResult.size(); i ++){
                Recruitinfo recruitResult = recruitinfoService.getById(beforeResult.get(i).getRecruitId());
                RecruitinfoParams params = new RecruitinfoParams();
                BeanUtils.copyProperties(recruitResult,params);
                Businessinfo businessinfo = businessinfoService.getById(recruitResult.getBusinessId());
                String json = JSONObject.toJSON(businessinfo).toString();
                params.setBusinessinfoString(json);
                resultList.add(params);
            }
            return ApiResult.buildSuccess(resultList);
        }else{
            //记录集合
            List<List<String>> record = new ArrayList<List<String>>();
            //从投递信息表查到所有投递信息，所有投递信息作为标签,查出所有投递信息中未招聘满并且之前未投递过的所有信息
            List<Deliverinfo> deliverinfos = deliverinfoDao.listAll();
            List<Recruitinfo> deleveryRecruits = new ArrayList<>();
            for(int i = 0; i < deliverinfos.size(); i ++){
                //辅助数组
                List<String> a = new ArrayList<String>();
                Scoreinfo scoreinfo = new Scoreinfo();
                scoreinfo.setAccountId(deliverinfos.get(i).getAccountId());
                scoreinfo.setRecruitId(deliverinfos.get(i).getRecruitId());
                List<Scoreinfo> listScore = scoreinfoDao.list(scoreinfo);
                Recruitinfo recruitToolVo = recruitinfoDao.getById(deliverinfos.get(i).getRecruitId());
                if(listScore.size() > 0 && "3".equals(listScore.get(0).getScoreNum())){
                    a.add("@中评");
                }else if(listScore.size() > 0 && ("4".equals(listScore.get(0).getScoreNum()) || "5".equals(listScore.get(0).getScoreNum()))){
                    a.add("@@好评");
                }
                a.add("@@@" + recruitToolVo.getRecruitType());
                a.add("@@@@" + recruitToolVo.getBeginTime() + "@@@@" + recruitToolVo.getOverTime());
                record.add(a);
            }
            List<List<String>> ruleResults = new ArrayList<>();
            ruleResults = AprioriMyself.getResult(record);

            List<Map<String,String>> tagTagList = new ArrayList<>();
            int size1 = ruleResults.size();

            for(int i = 0; i < size1; i ++){
                int le = ruleResults.get(i).size();
                List<Map<String,String>> tagList = new ArrayList<>();
                Map<String,String> tagMap = new HashMap<>();

                for(int j = 0; j < le; j ++){
                    char[] ch = ruleResults.get(i).get(j).toCharArray();
                    int num = 0;
                    for(int k = 0; k < ch.length; k ++){
                        if(ch[k] == '@'){
                            num ++;
                        }
                    }
                    if(num == 1){
                        tagMap.put("score",3+"");
                    }else if(num == 2){
                        tagMap.put("score","4");
                    }else if (num == 3) {
                        tagMap.put("recruitType",""+(ruleResults.get(i).get(j).substring(3)));
                    }else if (num == 8) {
                        String a = ruleResults.get(i).get(j).substring(4);
                        char[] chTool = a.toCharArray();
                        int len = chTool.length;
                        String aTool = "";
                        String bTool = "";
                        if(chTool[1] != '@'){
                            aTool += chTool[0];
                            aTool += chTool[1];
                            for(int cha = 6; cha < len; cha ++){
                                bTool += chTool[cha];
                            }
                            tagMap.put("start",aTool);
                            tagMap.put("end",bTool);
                        }else{
                            aTool += chTool[0];
                            for(int cha = 5; cha < len; cha ++){
                                bTool += chTool[cha];
                            }
                            tagMap.put("start",aTool);
                            tagMap.put("end",bTool);
                        }
                    }
                }
                tagTagList.add(tagMap);
            }
            //set存储所有不重复的兼职id
            List<RecruitScoreBusiness> recruitInfoVos = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < tagTagList.size(); i ++){

                RecruitScoreBusiness recruitScoreBusiness = new RecruitScoreBusiness();
                recruitScoreBusiness.setNeedSex(studentinfo.getSex());
                for(Map.Entry<String, String> entry:tagTagList.get(i).entrySet()){
                    if("recruitType".equals(entry.getKey())){
                        if("不限".equals(entry.getValue())){
                            if(!"不限".equals(studentinfo.getHopeJob1())){
                                recruitScoreBusiness.setRecruitType1(studentinfo.getHopeJob1());
                                recruitScoreBusiness.setRecruitType(null);
                            }else {
                                recruitScoreBusiness.setRecruitType1(null);
                                recruitScoreBusiness.setRecruitType(null);
                            }

                        }else{
                            recruitScoreBusiness.setRecruitType(entry.getValue());
                        }
                    }else if("start".equals(entry.getKey())){
                        recruitScoreBusiness.setBeginTime(Integer.parseInt(entry.getValue()));
                    }else if("end".equals(entry.getKey())){
                        recruitScoreBusiness.setOverTime(Integer.parseInt(entry.getValue()));
                    }else if("3".equals(entry.getKey())){
                        recruitScoreBusiness.setScoreNum("3");
                    }else if("4".equals(entry.getKey())){
                        recruitScoreBusiness.setScoreNum("4");
                    }

                }
                recruitInfoVos = recruitinfoDao.list2(recruitScoreBusiness);
                for(int m = 0; m < recruitInfoVos.size(); m++){
                    set.add(recruitInfoVos.get(m).getId());
                }
                recruitInfoVos.clear();
            }
//            List<>
            //查询出所有经过算法后的兼职
            Iterator<Integer> it = set.iterator();
            List<Integer> integerIds = new ArrayList<>();
            while (it.hasNext()) {
                Integer str = it.next();
                integerIds.add(str);
            }
            Integer[] inte = new Integer[integerIds.size()];
            for(int i = 0; i < integerIds.size(); i ++){
                inte[i] = integerIds.get(i);
            }
            List<Recruitinfo> allRecruits = recruitinfoDao.selectByIds(inte);
            //只留下未投递和未招满的集合
            List<Recruitinfo> listCommend = new ArrayList<>();
            for(int i = 0; i < allRecruits.size(); i ++){
                //该职位已通过人数
                int hasOffer = deliverinfoService.selectHasDelivery(allRecruits.get(i).getId());
                //查询该招聘信息招聘人数
                int needNum = recruitinfoService.getById(allRecruits.get(i).getId()).getRecruitNum();
                //是否已经投递该职位
                int hasdelivery = deliverinfoService.selectIsHasDelivery((Integer) session.getAttribute("id"),allRecruits.get(i).getId());
                //未招聘满并且未投递过
                if(hasOffer < needNum && hasdelivery <= 0){
                    listCommend.add(allRecruits.get(i));
                }
            }
            return ApiResult.buildSuccess(listCommend);
        }
    }
}
