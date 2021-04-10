package com.struct;

public class MyArray {
    private int[] elements;


    public MyArray() {
        this.elements = new int[0];
    }

    //获取数组长度的方法
    public int size() {
        return elements.length;
    }
}
