package org.example;

import java.awt.*;

public class Decorator {

    public static void main(String[] args) {
        BaseIceCream baseIceCream = new BaseIceCream();
        HoneyDecorator iceCreamWithHoney = new HoneyDecorator(baseIceCream);
        NuttyDecorator iceCreamWithNutty = new NuttyDecorator(iceCreamWithHoney);

        System.out.println(iceCreamWithNutty.makeIceCream());
    }


}

interface IceCream{
    String makeIceCream();
}

class BaseIceCream implements IceCream{

    @Override
    public String makeIceCream() {
        return "Base IceCream";
    }
}

abstract class IceCreamDecorator implements IceCream{
    protected IceCream specialIceCream;

    public IceCreamDecorator(IceCream specialIceCream) {
        this.specialIceCream = specialIceCream;
    }

    public String makeIceCream(){
        return specialIceCream.makeIceCream();
    }
}

class HoneyDecorator extends IceCreamDecorator{

    public HoneyDecorator(IceCream specialIceCream) {
        super(specialIceCream);
    }

    public String makeIceCream(){
        return super.makeIceCream() + addHoney();
    }

    private String addHoney(){
        return " + honey";
    }
}

class NuttyDecorator extends IceCreamDecorator {
    public NuttyDecorator(IceCream specialIceCream) {
        super(specialIceCream);
    }

    public String makeIceCream(){
        return super.makeIceCream() + addNutty();
    }

    private String addNutty(){
        return " + Nutty";
    }
}

