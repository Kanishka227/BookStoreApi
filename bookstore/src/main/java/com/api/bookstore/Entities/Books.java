package com.api.bookstore.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Books {
    @Id
    private int id;
    private String title;
    private String author;

    public Books(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Books() {
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
