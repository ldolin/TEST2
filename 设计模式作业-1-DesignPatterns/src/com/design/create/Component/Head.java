package com.design.create.Component;

/**
 * 描述: Todo
 *
 */
public class Head implements Component {
    private String name = null;
    public void setHead(String name){
        this.name = name;
    }
    public String getHead(){
        return name;
    }
}
