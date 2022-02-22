package com.firsttask.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.firsttask.model.*; 
//repository that extends CrudRepository  

public interface BooksRepository extends CrudRepository<Books, Integer>  
{  
}  