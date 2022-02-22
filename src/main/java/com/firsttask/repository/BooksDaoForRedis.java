package com.firsttask.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.firsttask.model.BookForCache;
@Repository
public class BooksDaoForRedis {

    public static final String HASH_KEY = "books";
    @Autowired
    private RedisTemplate template;

    public BookForCache save(BookForCache book){
        template.opsForHash().put(HASH_KEY,book.getBookid(),book);
        return book;
    }

    public List<BookForCache> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public BookForCache findProductById(int id){
        return (BookForCache) template.opsForHash().get(HASH_KEY,id);
    }


    public String deleteProduct(int id){
         template.opsForHash().delete(HASH_KEY,id);
        return "product removed !!";
    }
}


