package org.example;

public class Command {

    public static void main(String[] args) {
        Light light = new Light();
        TurnOn turnOnCommand = new TurnOn(light);
        RemoteControl control = new RemoteControl(turnOnCommand);
        control.turnOn();
        control.turnOff();
    }

}

class Light{
    public String getLight(){
        return "Light 1";
    }
}

/*
* Main Command Part
* Start
* */
interface ICommand{
    void execute();
    void undoExecute();
}

class TurnOn implements ICommand{

    private final Light light;

    public TurnOn(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.println(light.getLight() + " : Turn on");
    }

    @Override
    public void undoExecute() {
        System.out.println(light.getLight() + " : Turn Off");
    }
}
/*
 * Main Command Part
 * End
 * */


class RemoteControl{
    //Invoker
    //Handle Commands
    //Can have list of commands
    private final ICommand command;

    public RemoteControl(ICommand command) {
        this.command = command;
    }

    public void turnOn(){
        command.execute();
    }

    public void turnOff(){
        command.undoExecute();
    }
}

