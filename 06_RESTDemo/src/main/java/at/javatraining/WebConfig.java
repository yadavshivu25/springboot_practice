package at.javatraining;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //WebMvcConfigurer.super.extendMessageConverters(converters);
        YAMLMapper yamlMapper = new YAMLMapper();
        yamlMapper.findAndRegisterModules();

        //HttpMessageConverter<?> yamlConverter = AbstractGenericHttpMessageConverter<?>
        HttpMessageConverter<?> yamlConverter = new AbstractJackson2HttpMessageConverter(
                yamlMapper,
                new MediaType("application", "yaml")
        ) {};

        converters.add(yamlConverter);


    }
}
