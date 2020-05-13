package ru.netology.domain;

import lombok.Data;

@Data
public class Book extends Product {
    private String author;

    public Book() {
    }

    public Book(int id, int cost, String name, String author) {
        super(id, cost, name);
        this.author = author;
    }
}
