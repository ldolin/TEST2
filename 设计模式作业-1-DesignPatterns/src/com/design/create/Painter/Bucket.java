package com.design.create.Painter;


public class Bucket implements Painter {
    private String name = "桶";
    @Override
    public void draw() {
        System.out.println("我是"+name);
    }

    @Override
    public String toString() {
        return name;
    }
}
