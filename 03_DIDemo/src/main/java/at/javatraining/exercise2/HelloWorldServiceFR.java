package at.javatraining.exercise2;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("french")
public class HelloWorldServiceFR implements HelloWorldService {
    @Override
    public void sayHello() {
        System.out.println("Bonjour le monde!");
    }
}
