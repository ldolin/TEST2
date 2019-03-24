package com.design.create.Color;

/**
 * 描述: Todo
 *
 */
public class Color {
    private String name;
    private String RGB;

    // 引用传递
    public Object clone(){
        return this;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setRGB(String rgb){
        this.RGB = rgb;
    }

    public String getRGB(){
        return RGB;
    }

    @Override
    public String toString() {
        return this.name + this.RGB;
    }
}
