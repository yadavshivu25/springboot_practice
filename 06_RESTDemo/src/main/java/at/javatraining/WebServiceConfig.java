package at.javatraining;

import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// see https://cxf.apache.org/docs/springboot.html
@Configuration
public class WebServiceConfig {

   // @Autowired
    //private Bus bus;

    //@Autowired
    //private NewsWebService newsWebService;
    @Bean
    Endpoint endpoint(Bus bus, NewsWebService newsWebService){
        Endpoint endpoint = new EndpointImpl(bus, newsWebService);
        endpoint.publish("/NewsWebService");
        return endpoint;
    }
}
