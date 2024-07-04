package at.javatraining.exercise1;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@German
@Profile({"default", "de"})
public class HelloWorldServiceDE implements HelloWorldService{
    @Override
    public void sayHello() {
        System.out.println("Hallo Welt!");
    }
}
