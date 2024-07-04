package at.javatraining.exercise2;

import org.springframework.beans.factory.annotation.Qualifier;

public class HelloWorldServiceDE implements HelloWorldService {
    @Override
    public void sayHello() {
        System.out.println("Hallo Welt!");
    }
}
