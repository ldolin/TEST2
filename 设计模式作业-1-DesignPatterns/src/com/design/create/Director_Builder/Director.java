package com.design.create.Director_Builder;

import com.design.create.Canvas.Canvas;
import com.design.create.Director_Builder.BluePrint.BluePrint;
import com.design.create.Painter.Brush;
import com.design.create.Painter.Painter;
import com.design.create.PersonCharacter.PersonCharacter;

/**
 * 描述: 生产领导
 */
public class Director {
    private CanvasBuilderA builderA = new CanvasBuilderA();
    private CanvasBuilderB builderB = new CanvasBuilderB();


    // 建造一个小猪佩奇
    public Canvas buildA(){
        String head = "吹风机";
        String body = "黄色T恤";
        String foot = "尾巴";
        return createCanvas(builderA, "pink", new Brush(), new PersonCharacter(head, body, foot));
    }

//    public Canvas buildB(){}

    private Canvas createCanvas(CanvasBuilder builder, String color, Painter painter, PersonCharacter character){
        BluePrint bluePrint = new BluePrint();
        bluePrint.setColor(color);
        bluePrint.setPainter(painter);
        bluePrint.setCharacter(character);

        builder.setBluePrint(bluePrint);
        return builder.buildCanvas();
    }
}
