package com.design.create.Painter;


public class Pencil implements Painter {
    private String name = "铅笔";
    @Override
    public void draw() {
        System.out.println("我是"+name);
    }

    @Override
    public String toString() {
        return name;
    }
}
