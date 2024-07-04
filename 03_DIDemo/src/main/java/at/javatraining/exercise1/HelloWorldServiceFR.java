package at.javatraining.exercise1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Qualifier("french")
@Profile({"default", "fr"})
public class HelloWorldServiceFR implements HelloWorldService{
    @Override
    public void sayHello() {
        System.out.println("Bonjour le monde!");
    }
}
