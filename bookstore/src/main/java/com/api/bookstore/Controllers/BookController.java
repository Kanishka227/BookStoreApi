package com.api.bookstore.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.bookstore.Entities.Books;
import com.api.bookstore.Services.BookService;

@RestController
public class BookController {
    
    @Autowired
    private BookService bookService;
    @GetMapping("/books")
    public ResponseEntity<List<Books>> getBook(){
        List<Books> list = bookService.getAllBooks();
        if(list.size() < 1){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable("id") int id){

        Books b = bookService.getBookById(id);
        if(b == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(b);

    }
    @PostMapping("/books")
    public Books addBook(@RequestBody Books book){
      Books b = bookService.addBook(book);
      return b;
    }

    @DeleteMapping("/books/{bid}")
    public void deleteBook(@PathVariable("bid")int id){
        bookService.deleteBook(id);
    }

    @PutMapping("/books/{bid}")
    public Books updateBook(@RequestBody Books book, @PathVariable("bid")int id){

        this.bookService.updateBook(book, id);
        return book;
    }
}
