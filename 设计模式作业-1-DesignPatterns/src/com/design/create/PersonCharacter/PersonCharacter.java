package com.design.create.PersonCharacter;

import com.design.create.Component.Body;
import com.design.create.Component.Head;
import com.design.create.Component.Foot;


public class PersonCharacter {
    private Head head = new Head();
    private Body body = new Body();
    private Foot foot = new Foot();
    public PersonCharacter(String head, String body, String foot){
        this.head.setHead(head);
        this.body.setBody(body);
        this.foot.setFoot(foot);
    }

    @Override
    public String toString() {
        return "头部:"+head.getHead()+"\n"+"身体:"+body.getBody()+"\n"+"尾部:"+foot.getFoot();
    }
}
