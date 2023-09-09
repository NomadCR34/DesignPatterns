package org.example;

import java.util.Objects;

public class Proxy {
    /*
    * 1- Remote -> Used when you want access to a remote resource, so the proxy is responsible for sending the requests and gets the results.
    * 2- Virtual -> Control access to a resource that it is expensive to create
    * 3- Protection -> It would be used to make sure that only users who have permission are allowed access to a particular resource.
    * */

    public static void main(String[] args) {
        ProxySubject proxySubject = new ProxySubject("Value1");
        proxySubject.request();
    }
}

interface ISubject{
    void request();
}

class Subject implements ISubject{

    private final String value;

    public Subject(String value) {
        this.value = value;
    }

    @Override
    public void request() {
        System.out.printf("Request sent with %s",value);
    }
}

class ProxySubject implements ISubject{

    /*
    * Proxy behave as ISubject and has Subject.
    * */

    private Subject subject;
    private final String value;

    public ProxySubject(String value) {
        this.value = value;
    }

    @Override
    public void request() {
        if(Objects.isNull(subject)){
            subject = new Subject(value);
        }
        // do somethings
        subject.request();
    }
}
