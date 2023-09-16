package org.example;

public class TemplateMethod {
    public static void main(String[] args) {
        Example example = new Example();
        example.templateMethod();

        Example2 example2 = new Example2();
        example2.templateMethod();
    }

}

abstract class Template{

    public void templateMethod(){
        System.out.println("Do some thing 1");
        operation1();
        System.out.println("Do some thing 2");
        operation2();
        System.out.println("Do some thing 3");
    }

    abstract void operation1();//code that is different base on subClass
    abstract void operation2();//code that is different base on subClass
}


class Example extends Template{

    @Override
    void operation1() {
        System.out.println("operation 1");
    }

    @Override
    void operation2() {
        System.out.println("operation 2");
    }
}

class Example2 extends Template{

    @Override
    void operation1() {
        System.out.println("task 1");
    }

    @Override
    void operation2() {
        System.out.println("task 2");
    }
}
