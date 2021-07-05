package com.algorithm.study;

import com.minxing365.util.crypto.AesUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @Author: yangzhi
 * @Description: com.algorithm.study
 * @Date: Create in 2021-04-19 2320
 */
public class Test {
    public static void main(String[] args)  {

        String dddd ="abcd、";
        System.out.println(dddd.substring(0,dddd.length()-1));
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        for(int i=list.size()-1;i>=0;i--)
        {
            System.out.println(list.get(i));
        }






        HashMap<Integer,String> abc = new HashMap<Integer, String>(8,0.75f);
        for(int i=8;i<20;i++)
        {
            abc.put(i,i+"");
        }
        Set<Integer> integers = abc.keySet();
        for(Integer item:integers)
        {
            System.out.println(abc.get(item));
        }
        Long time1 =System.currentTimeMillis();
        for(int i=0;i<100000;i++)
        {
            System.out.println(i+" 能否被2整除："+(i%2==0));
        }
        Long time2 =System.currentTimeMillis();
        System.out.println(time2 -time1);
    }
}