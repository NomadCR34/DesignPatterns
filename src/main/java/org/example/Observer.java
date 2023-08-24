package org.example;

import java.util.ArrayList;
import java.util.List;

public class Observer {

    public static void main(String[] args) {

    }

}

interface IObservable{
    void add(IObserver observer);
    void remove(IObserver observer);
    void notifyObservers();
}

interface IObserver{
    void update();
}

class ConcreteObservable implements IObservable{

    private Boolean state;
    private final List<IObserver> observers;

    public ConcreteObservable() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void add(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(IObserver::update);
    }

    /*
    * Get Current State
    * */
    public Boolean getState(){
        return this.state;
    }
}

class ConcreteObserver implements IObserver{

    private final ConcreteObservable observable;

    public ConcreteObserver(ConcreteObservable observable) {
        this.observable = observable;
    }

    /*
    * When ever state of observable change it will call update method
    * then observer is going to get last state from observable instance
    * */
    @Override
    public void update() {
        // do something with new state
        System.out.println(observable.getState());
    }
}
