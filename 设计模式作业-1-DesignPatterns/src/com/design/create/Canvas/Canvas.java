package com.design.create.Canvas;

import com.design.create.ColorfulPainter.ColorfulPainter;
import com.design.create.PersonCharacter.PersonCharacter;

/**
 * 描述: 最终的画布
 */
public class Canvas {
    private ColorfulPainter colorPtr;
    private PersonCharacter character;

    public Canvas(ColorfulPainter colorPtr, PersonCharacter character){
        this.colorPtr = colorPtr;
        this.character = character;
    }

    public void show(){
        System.out.println(colorPtr);
        System.out.println(character);
    }
}
