package com.structure.stackTest;

/**
 * @Author: yangzhi
 * @Description: com.structure.stackTest
 * @Date: Create in 2021-05-01 1526
 */
public class StackMain {

    public static void main(String[] args) {
        StackWithArray stackWithArray = new StackWithArray(5);
        for(int i=0;i<5;i++){
            System.out.println(stackWithArray.push(i));
        }
        for(int i=0;i<5;i++){
            System.out.println(stackWithArray.pop());
        }


    }


}
