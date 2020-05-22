package ru.netology.domain;

import lombok.Data;

@Data
public class Book extends Product {
    private String author;

    public Book(int id, int cost, String name, String author) {
        super(id, cost, name);
        this.author = author;
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (author.equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }

}
