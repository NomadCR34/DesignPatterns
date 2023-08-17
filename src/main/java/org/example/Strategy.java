package org.example;

public class Strategy {

    public static void main(String[] args) {
        SimpleQuack simpleQuack = new SimpleQuack();
        DoubleQuack doubleQuack = new DoubleQuack();
        SimpleFly simpleFly = new SimpleFly();
        Duck duck = new Duck(simpleQuack,simpleFly);
        duck.fly();
        duck.quack();
    }

}

interface IDuckBehavior{
    void quack();
}

interface IFlyBehavior{
    void fly();
}

class SimpleFly implements IFlyBehavior{

    @Override
    public void fly() {
        System.out.println("Fly");
    }
}

class NoFly implements IFlyBehavior{

    @Override
    public void fly() {
    }
}

class SimpleQuack implements IDuckBehavior{

    @Override
    public void quack() {
        System.out.println("Quack");
    }
}

class DoubleQuack implements IDuckBehavior{

    @Override
    public void quack() {
        System.out.println("Quack Quack");
    }
}

class Duck {

    private final IDuckBehavior duckBehavior;//Duck has IDuckBehavior
    private final IFlyBehavior flyBehavior;//Duck has IFlyBehavior

    public Duck(IDuckBehavior duckBehavior, IFlyBehavior flyBehavior) {
        this.duckBehavior = duckBehavior;
        this.flyBehavior = flyBehavior;
    }

    public void quack() {
        duckBehavior.quack();
    }

    public void fly() {
        flyBehavior.fly();
    }
}
