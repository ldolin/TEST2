package com.design.create.ColorfulPainter;

import com.design.create.Color.Color;
import com.design.create.Painter.Painter;

/**
 * 描述: 带颜色的画笔
 *
 */
public class ColorfulPainter {
    private Color color;
    private Painter painter;

    public ColorfulPainter(Color color, Painter painter){
        this.color = color;
        this.painter = painter;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void setPainter(Painter painter){
        this.painter = painter;
    }

    public Color getColor(){
        return color;
    }

    public Painter getPainter(){
        return painter;
    }

    @Override
    public String toString() {
        return "画笔:"+painter.toString() + "\t" + "颜色:" + color.toString();
    }
}
