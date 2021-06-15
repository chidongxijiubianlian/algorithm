package com.algorithm.study.recursion;

/**
 * recursion叫做递归  递过去 再回来
 * @Author: yangzhi
 * @Description: 来到电影院 看不清现在坐在第几排，想知道的话只能问前面的人
 * 前面的人也看不清 再问前面的人 直到第一个人
 * @Date: Create in 2021-05-11 2104
 */
public class SeeMoive {

    public static void main(String[] args) {
        SeeMoive seeMoive = new SeeMoive();
        System.out.println(seeMoive.whereIamI(4));
    }


    private int whereIamI(int n)
    {
        if(n ==1){
            return n;
        }else{
            return whereIamI(n-1)+1;
        }
    }
}
