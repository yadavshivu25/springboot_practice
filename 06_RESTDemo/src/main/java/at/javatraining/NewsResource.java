package at.javatraining;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/resources/news")

@Log
public class NewsResource {
    @Autowired
    private NewsRepository newsRepository;

    //@GetMapping("/resources/news")

    @GetMapping
    public List<News> retrieveAll(@RequestParam("cattegoryid") Optional<Long> optCategoryId){
        //log.("Calling this");
        log.info("retrieveAll()");
        if(optCategoryId.isPresent()){
            return newsRepository.findAllByCategoryId(optCategoryId.get());
        }
        return newsRepository.findAll();
    }

    @GetMapping("/{id}")
    public News retrieve(@PathVariable("id") Long id){
        log.info("id - "+id);
        log.info("retrieve()=> id:"+id);
        return newsRepository.findById(id)
                .orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        log.info("id - "+id);
        log.info("delete()=> id:"+id);
        newsRepository.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody News news){
        log.info("create()=> News:"+news);

        news.setId(null);
        news = newsRepository.save(news);

        //URI location = URI.create("http://localhost:8080/resources/news/"+news.getId());
        URI location = WebMvcLinkBuilder.linkTo(
               WebMvcLinkBuilder.methodOn(getClass()).retrieve(news.getId())
        ).toUri();

        return ResponseEntity.status(201).location(location).build();
    }

    @PutMapping("/{id}")
    public void update(@RequestBody News news, Long id){
        log.info("update()=> id:"+id);
        news.setId(id);
        newsRepository.save(news);
    }

}
