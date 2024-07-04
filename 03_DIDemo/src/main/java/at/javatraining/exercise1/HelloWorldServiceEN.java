package at.javatraining.exercise1;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile({"default", "en"})
public class HelloWorldServiceEN implements HelloWorldService{
    @Override
    public void sayHello() {
        System.out.println("Hello World!");
    }
}
