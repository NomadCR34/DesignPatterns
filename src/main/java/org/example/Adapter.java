package org.example;

public class Adapter {

    public static void main(String[] args) {
        AdapteeExample adapteeExample = new AdapteeExample();
        AdapterExample adapter = new AdapterExample(adapteeExample);
        Client client = new Client(adapter);
        client.request();
    }
}


interface ITarget{
    void request();
}

interface IAdaptee{
    void specificRequest();
}


class Client{
    private final ITarget target;

    public Client(ITarget target) {
        this.target = target;
    }

    public void request(){
        target.request();
    }
}

class AdapterExample implements ITarget{

    private final AdapteeExample adapteeExample;

    public AdapterExample(AdapteeExample adapteeExample) {
        this.adapteeExample = adapteeExample;
    }

    @Override
    public void request() {
        adapteeExample.specificRequest();
    }
}

class AdapteeExample implements IAdaptee{

    @Override
    public void specificRequest() {
        System.out.println("Special Request");
    }
}
