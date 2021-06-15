package com.structure.bitmap;

/**
 * @Author: yangzhi
 * @Description: com.structure
 * @Date: Create in 2021-06-10 1455
 */
public class BitMap {
    private byte[] bytes;
    private int size;

    public BitMap(int inputSize)
    {
        //右移三位和inputSize/8是一个意思
        this.size =(inputSize>>3)+1;
        bytes =new byte[size];
    }

    public void set(int number)
    {
        //首先获取到该number在byte[]中的索引位置
        int index =number>>3;
        //取余运算可以替换为 number & 0x07
        //其实不用非得十六进制 0x07 写7也是可以的
        //7对应二进制位  0000 0111
        //与这个东西做与运算 就是把除了低三位的数给干掉了 也就是%8
        int position =number & 0x07;
        bytes[index] |=(1<<position);
    }

    public boolean contains(int number){
        int index =number>>3;
        int position =number &0x07;
        int i = bytes[index] & 1 << position;
        return i!=0;
    }

    public void rest(int number){
        int index =number>>3;
        int position =number &0x07;
        //1 左移position个位置 比如position是2
        //0000 0001就变成了 0000 0100
        //取反就变成了 1111 1011
        //再和byte[index]中的byte做& 就自然清空了 position
        bytes[index] &=~(1<<position);
    }


    public static void main(String[] args) {
        BitMap bitMap = new BitMap(300);
        bitMap.set(244);
        System.out.println(bitMap.contains(244));
        bitMap.rest(244);
        System.out.println(bitMap.contains(244));
    }
}
