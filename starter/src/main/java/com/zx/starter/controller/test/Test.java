package com.zx.starter.controller.test;

import java.util.*;

/**
 * @author zhouxiong
 * @Title: Test
 * @ProjectName study_lab
 * @Description: TODO
 * @date 2019/8/1511:24
 */
public class Test {

    public static void main(String[] args) {
        /*int a = 486;
        int b = 48;
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(Double.valueOf(df.format((float) b/a)));*/

        /*//这里的数后面加“D”是表明它是Double类型，否则相除的话取整，无法正常使用
        double percent = 50.5D / 150D;

        //输出一下，确认你的小数无误
        System.out.println("小数：" + percent);

        //获取格式化对象
        NumberFormat nt = NumberFormat.getPercentInstance();

        //设置百分数精确度2即保留两位小数
        nt.setMinimumFractionDigits(2);

        //最后格式化并输出
        System.out.println("百分数：" + nt.format(percent));*/
        Long[] m = {3L,4L};
        Long[] n = null;
        List<Long> c =null;
        c = new ArrayList<>();

        List<Long> a = new ArrayList<>(Arrays.asList(m));
        List<Long> b = new ArrayList<>(Arrays.asList(n));
       a.removeAll(b);
        for (Long i : a){
            System.out.println(i);
        }
        /*for (Long l: occur(m, n)){
            System.out.println(l);
        }*/
    }
    /**
     * 求差集
     *
     * @param m
     * @param n
     * @return
     */
    private static Long[] occur(Long[] m, Long[] n)
    {
        Set<Long> set = new HashSet<>(Arrays.asList(m));
        Set<Long> result = new HashSet<>();
        for (Long i :  n)
        {
            if (set.contains(i)) continue;
            else result.add(i);
        }
        Long[] arr = {};
        return result.toArray(arr);
    }
}
