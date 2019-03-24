package com.design.create.TEST;

import com.design.create.Canvas.Canvas;
import com.design.create.Director_Builder.Director;


public class MainClass {
    public static void main(String[] args){
        
        Director demo = new Director();
        Canvas canvas = demo.buildA();
        canvas.show();
    }
}
