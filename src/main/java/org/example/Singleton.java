package org.example;

public class Singleton {

    public static void main(String[] args) {
        Connection instance = Connection.INSTANCE;
        instance.donSomething();

    }

}

enum Connection{
    INSTANCE;

    public void donSomething(){
        System.out.println("do something with singleton");
    }
}
