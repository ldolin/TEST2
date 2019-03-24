package com.design.create.Director_Builder;

import com.design.create.Canvas.Canvas;
import com.design.create.ColorfulPainter.ColorfulPainter;
import com.design.create.Director_Builder.BluePrint.BluePrint;
import com.design.create.PersonCharacter.PersonCharacter;

/**
 * 描述: Todo
 *
 */
public abstract class CanvasBuilder {

    abstract ColorfulPainter buildColorfulPainter();
    abstract PersonCharacter buildCharacter();

    private BluePrint bluePrint;

    Canvas buildCanvas(){
        return new Canvas(buildColorfulPainter(), buildCharacter());
    }

    void setBluePrint(BluePrint bluePrint){
        this.bluePrint = bluePrint;
    }

    protected BluePrint getBluePrint(){
        return this.bluePrint;
    }
}
