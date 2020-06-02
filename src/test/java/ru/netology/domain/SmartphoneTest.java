package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    private Smartphone secondSmart = new Smartphone(4, 330, "7.2", "Nokia");

    @Test
    void shouldMatchesTrueName() {
        assertTrue(secondSmart.matches("7.2"));
    }

    @Test
    void shouldMatchesFalseName() {
        assertFalse(secondSmart.matches("7"));
    }

    @Test
    void shouldMatchesTrueManufacture() {
        assertTrue(secondSmart.matches("Nokia"));
    }

    @Test
    void shouldMatchesFalseManufacture() {
        assertFalse(secondSmart.matches("Motorola"));
    }
}