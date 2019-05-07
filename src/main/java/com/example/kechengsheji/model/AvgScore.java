package com.example.kechengsheji.model;

public class AvgScore implements Comparable{
    private Integer recruitId;

    private Double scoreNum;

    public Integer getRecruitId() {
        return recruitId;
    }

    public void setRecruitId(Integer recruitId) {
        this.recruitId = recruitId;
    }

    public Double getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(Double scoreNum) {
        this.scoreNum = scoreNum;
    }

    //对象数组排序
    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub

        if (o instanceof AvgScore) {
            AvgScore s = (AvgScore) o;
            if (this.scoreNum > s.scoreNum) {
                return -1;
            } else if (this.scoreNum == s.scoreNum) {
                return 0;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
