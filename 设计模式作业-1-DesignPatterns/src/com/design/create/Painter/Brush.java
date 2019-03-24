package com.design.create.Painter;


public class Brush implements Painter {
    private String name = "刷子";
    @Override
    public void draw() {
        System.out.println("我是"+name);
    }

    @Override
    public String toString() {
        return name;
    }
}
