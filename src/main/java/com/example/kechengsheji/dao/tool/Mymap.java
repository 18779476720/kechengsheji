package com.example.kechengsheji.dao.tool;

import java.util.LinkedList;
import java.util.List;

public class Mymap {
    public List<String> li = new LinkedList<>();
    public int count;

    public Mymap(List<String> l, int c) {// 构造函数  新建一个对象
        li = l;
        count = c;
    }

    public int getcount() {// 返回得到当前频繁项集的支持度计数
        return count;
    }

    public boolean isListEqual(List<String> in) {// 判断传入的频繁项集是否和本频繁项集相同
        if (in.size() != li.size())// 先判断大小是否相同
            return false;
        else {
            for (int i = 0; i < in.size(); i++) {// 遍历输入的频繁项集，判断是否所有元素都包含在本频繁项集中
                if (!li.contains(in.get(i)))
                    return false;
            }
        }
        return true;// 如果两个频繁项集大小相同，同时本频繁项集包含传入的频繁项集的所有元素，则表示两个频繁项集是相等的，返回为真
    }
}
