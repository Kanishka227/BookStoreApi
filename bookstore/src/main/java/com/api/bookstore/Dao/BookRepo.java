package com.api.bookstore.Dao;

import org.springframework.data.repository.CrudRepository;

import com.api.bookstore.Entities.Books;

public interface BookRepo extends CrudRepository<Books,Integer>{
    
    public Books findById(int id);
}
