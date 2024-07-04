package at.javatraining.exercise2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private HelloWorldController hwController;

    @Autowired
    private HelloWorldController getHwController2;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        hwController.sayHello();
        hwController.sayHelloDE();

        if (hwController == getHwController2){
            System.out.println("Singleton... Same objects!");
        }
        else{
            System.out.println("Prototy...., different objects");
        }
    }
}
