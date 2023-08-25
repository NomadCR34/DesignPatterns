package org.example;

public class AbstractFactory {
    /*
    * We have multi product that they are in relation with other
    * in this example linuxForm and windowsForm
    * so each abstract factory will create related button and textBox
    * */
    public static void main(String[] args) {
        LinuxFormFactory linuxFormFactory = new LinuxFormFactory();
        Button linuxButton = linuxFormFactory.getButton();

        WindowsFormFactory windowsFormFactory = new WindowsFormFactory();
        Button windowsButton = windowsFormFactory.getButton();
    }

}

interface Button{}
interface TextBox{}

interface ICreateForm{
    Button getButton();
    TextBox getTextBox();
}

class LinuxButton implements Button{}
class LinuxTextBox implements TextBox{}
class WindowsButton implements Button{}
class WindowsTextBox implements TextBox{}

class LinuxFormFactory implements ICreateForm{

    @Override
    public Button getButton() {
        return new LinuxButton();
    }

    @Override
    public TextBox getTextBox() {
        return new LinuxTextBox();
    }
}

class WindowsFormFactory implements ICreateForm{

    @Override
    public Button getButton() {
        return new WindowsButton();
    }

    @Override
    public TextBox getTextBox() {
        return new WindowsTextBox();
    }
}
