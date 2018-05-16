package com.mmm;

import org.junit.Test;

public class suan {


    /**
     * 鸡兔同笼
     *
     * 有鸡兔共50头，共120只脚
     * 问  鸡兔共多少只
     *
     */
    @Test
    public void  suan(){
        int x ;
        int y ;

        for (x = 0; x <=50 ; x++) {

            y=50-x; //算出兔子的只数
            if (2*x+4*y==120) {
                System.out.println(x);
                System.out.println(y);
            }



        }

    }
    /**
     * 韩信点兵
     *
     * 韩信只知道部队有1000多人 但是具体数据不详
     * 5人一组，剩1人
     * 7人一组，剩2人
     * 8人一组，剩3人
     */
    @Test
    public  void  suan2(){
        int a;
        for ( a = 1000; a <2000 ; a++) {
            if (a%5==1 && a%7==2 && a%8==3) {
                System.out.println("韩信有部下:"+a);
            }
        }

    }


}
