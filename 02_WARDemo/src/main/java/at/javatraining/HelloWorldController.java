package at.javatraining;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.MemoryType;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {
    @Autowired
    ObjectMapper om;
    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping(produces=MediaType.TEXT_HTML_VALUE)
    public String sayHelloAsHtml(){
        return """
               <h1> Hello World! </h1> 
               """;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String sayHelloAsJson() throws Exception{
        ObjectNode objNode = om.createObjectNode().put("message","Hello World");
        return om.writeValueAsString(objNode);
    }
}
