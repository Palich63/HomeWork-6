package ru.netology.domain;

import lombok.Data;

@Data
public class Smartphone extends Product {
    private String manufacture;

    public Smartphone() {
    }

    public Smartphone(int id, int cost, String name, String manufacture) {
        super(id, cost, name);
        this.manufacture = manufacture;
    }
}
