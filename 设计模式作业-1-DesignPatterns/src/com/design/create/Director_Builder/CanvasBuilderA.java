package com.design.create.Director_Builder;

import com.design.create.Color.Color;
import com.design.create.ColorfulPainter.ColorfulPainter;
import com.design.create.Painter.Painter;
import com.design.create.PersonCharacter.PersonCharacter;

/**
 * 描述: 建造一个小猪佩奇
 *
 */
public class CanvasBuilderA extends CanvasBuilder{

    ColorfulPainter buildColorfulPainter(){
        Color color = getBluePrint().getColor();
        Painter painter = getBluePrint().getPainter();
        return new ColorfulPainter(color, painter);
    }

    PersonCharacter buildCharacter(){
        return getBluePrint().getCharacter();
    }
}
