package at.javatraining.exercise2;

import org.springframework.beans.factory.annotation.Autowired;

public class HelloWorldController {
    @Autowired
    private HelloWorldService hwService;

    private HelloWorldService hwServiceDE;

    public HelloWorldController(){
        System.out.println("HelloWorldController!");
    }

    @Autowired
    @German
    public void setHelloWorldServiceDE(HelloWorldServiceDE hwServiceDE){
        this.hwServiceDE = hwServiceDE;
    }
    public void sayHello(){
        hwService.sayHello();
    }

    public void sayHelloDE(){
        hwServiceDE.sayHello();
    }
}
