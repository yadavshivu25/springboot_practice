package at.javatraining.exercise1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
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
