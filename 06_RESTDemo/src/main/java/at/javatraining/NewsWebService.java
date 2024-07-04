package at.javatraining;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@WebService (serviceName = "NewsWebServie")

@Log
public class NewsWebService {
    @Autowired
    private NewsRepository newsRepository;

    @WebMethod
    @Transactional
    public @WebResult(name = "news") News getNews(@WebParam(name = "id") long id){
        log.info("getNews()=> id:"+id);

        News news = newsRepository.findById(id)
                .orElse(null);

        log.info("News: "+news);
        System.out.println("News: "+news);

        return news;
    }

    @WebMethod
    @Transactional
    public @WebResult(name = "news") List<News> getAllNews(){
        log.info("getAllNews()");

        List<News> news = newsRepository.findAll();

        System.out.println("News: "+news);

        return news;

    }
}
