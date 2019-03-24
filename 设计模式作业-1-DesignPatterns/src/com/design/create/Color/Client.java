package com.design.create.Color;

/**
 * 描述: 测试
 *
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException{
        ColorManager manager = ColorManager.getInstance();
        Color color = manager.getColor("red");
        Color color1 = manager.getColor("red");
        System.out.println(color.getName());
        System.out.println(color.getRGB());
        System.out.println(color == color1);

    }
}
