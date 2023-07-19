package com.api.bookstore.Services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.bookstore.Dao.BookRepo;
import com.api.bookstore.Entities.Books;
@Component
public class BookService {

    @Autowired
    BookRepo bookrepo;


    public List<Books> getAllBooks(){
        List<Books> list = (List<Books>)bookrepo.findAll();
        return list;
    }

    public Books getBookById(int id){
        Books b = new Books();
        try{
        b = bookrepo.findById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
       
        return b;
    }

    public Books addBook(Books b){
        Books res = bookrepo.save(b);
        return res;
    }

    public void deleteBook(int id){
       bookrepo.deleteById(id);
    }

    public void updateBook(Books book ,int id){
       book.setId(id);
       bookrepo.save(book);
    }

}
