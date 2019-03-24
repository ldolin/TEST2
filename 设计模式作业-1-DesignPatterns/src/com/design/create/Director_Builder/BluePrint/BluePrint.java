package com.design.create.Director_Builder.BluePrint;

import com.design.create.Color.Color;
import com.design.create.Color.ColorManager;
import com.design.create.Painter.Painter;
import com.design.create.PersonCharacter.PersonCharacter;

/**
 * 描述: 设计蓝图,由领导指派,工厂依据蓝图建造
 *
 */
public class BluePrint {
    private Color color;
    private Painter painter;
    private PersonCharacter character;

    public void setColor(String name){
        ColorManager manager = ColorManager.getInstance();
        this.color = manager.getColor(name);
    }

    public Color getColor(){
        return color;
    }

    public void setPainter(Painter painter){
        this.painter = painter;
    }

    public Painter getPainter(){
        return painter;
    }

    public void setCharacter(PersonCharacter character){
        this.character = character;
    }

    public PersonCharacter getCharacter(){
        return character;
    }


}
