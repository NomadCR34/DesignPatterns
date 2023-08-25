package org.example;

public class FactoryMethod {

    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();
        Animal animal = animalFactory.createAnimal("Dog");

        System.out.println("Animal is instance of dog : " + (animal instanceof Dog));
    }


}


interface Animal{}

class Cat implements Animal{}

class Dog implements Animal{}

interface IAnimalFactory{
    Animal createAnimal(String animal);
}

class AnimalFactory implements IAnimalFactory{

    @Override
    public Animal createAnimal(String animal) {
        if(animal.equals("Dog")){
            return createDog();
        }
        return createCat();
    }

    private Dog createDog(){
        return new Dog();
    }

    private Cat createCat(){
        return new Cat();
    }
}