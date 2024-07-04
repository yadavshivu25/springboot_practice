package at.javatraining.exercise2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    HelloWorldController hwController(){
        return new HelloWorldController();
    }

    @Bean
    @Primary
    HelloWorldServiceEN hwServiceEN(){
        return new HelloWorldServiceEN();
    }

    @Bean
    @German
    HelloWorldServiceDE hwServiceDE(){
        return new HelloWorldServiceDE();
    }

    @Bean
    @Qualifier("french")
    HelloWorldServiceFR hwServiceFR(){
        System.out.println("HelloWorldServiceFR");
        return new HelloWorldServiceFR();
    }
}
