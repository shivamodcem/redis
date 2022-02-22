package com.firsttask.service;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.firsttask.model.*;
import com.firsttask.repository.*;  
//defining the business logic  
@Service  
public class BooksService   
{  
@Autowired  
BooksRepository booksRepository;  
@Autowired
BooksDaoForRedis cac;



//getting all books record by using the method findaAll() of CrudRepository  
public List<Books> getAllBooks()   
{  
List<Books> books = new ArrayList<Books>();  
//books = (List<Books>) template.opsForHash().values(HASH_KEY);
booksRepository.findAll().forEach(books1 -> books.add(books1));  
return books;  
}  
//getting a specific record by using the method findById() of CrudRepository  
//@Cacheable(value="books",key="#id")
public BookForCache getBooksById(int id)   
{  
	BookForCache bfc = cac.findProductById(id);
	if(bfc!=null)
	{
		return cac.findProductById(id);
	}
	
	Books b=booksRepository.findById(id).get();
	System.out.println("In db");
	
	BookForCache bf= new BookForCache();

	bf.setBookid(b.getBookid());

	bf.setAuthor(b.getAuthor());

	bf.setBookname(b.getBookname());

	bf.setPrice(b.getPrice());
	
	cac.save(bf);
	return bf;
}  
//saving a specific record by using the method save() of CrudRepository  
//@CachePut(value="Books",key="#books.getBookid()")

public void saveOrUpdate(Books b)   
{  
	
	
booksRepository.save(b);  
}  
//deleting a specific record by using the method deleteById() of CrudRepository  
//@CacheEvict(value="books",key="#id")
public void delete(int id)   
{  
cac.deleteProduct(id);
booksRepository.deleteById(id);  
}  
//updating a record  
//@CachePut(value="books",key="#bookid")
public Books update(Books b, int bookid)   
{  
	BookForCache bf= new BookForCache();

	bf.setBookid(b.getBookid());

	bf.setAuthor(b.getAuthor());

	bf.setBookname(b.getBookname());

	bf.setPrice(b.getPrice());
	
	cac.save(bf);
	return booksRepository.save(b);  
}  
}  