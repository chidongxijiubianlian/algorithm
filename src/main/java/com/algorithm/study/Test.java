package com.algorithm.study;

import com.minxing365.util.crypto.AesUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: yangzhi
 * @Description: com.algorithm.study
 * @Date: Create in 2021-04-19 2320
 */
public class Test {
    public static void main(String[] args)  {
        Long time1 =System.currentTimeMillis();
        for(int i=0;i<100000;i++)
        {
            System.out.println(i+" 能否被2整除："+(i%2==0));
        }
        Long time2 =System.currentTimeMillis();
        System.out.println(time2 -time1);
    }
}