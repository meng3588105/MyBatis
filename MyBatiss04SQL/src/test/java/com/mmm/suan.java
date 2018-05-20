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
    /**
     * 需要找零8元
     *      有零钞5元 、2元、1元、5角
     *
     *      求出所有的找零方案
     */
    @Test
        public void suan3(){
        for (int i = 0; i <=80/50 ; i++) {
            for (int j = 0; j <=80/20 ; j++) {
                for (int k = 0; k <=80/10 ; k++) {
                    for (int l = 0; l <80/5 ; l++) {
                        if (i*50+j*20+k*10+l*5==80){
                            System.out.println("5元的有：=="+i+"==》2元的有：=="+j+"==》1元的有=="+k+"==》5角的有=="+l);
                        }
                    }
                }
            }
        }





        }




}
