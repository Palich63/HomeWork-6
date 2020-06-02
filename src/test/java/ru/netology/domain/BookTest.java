package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookTest {

    private Book secondBook = new Book(3, 31, "Заводной апельсин", "Энтони Бёрджесс");

    @Test
    void shouldMatchesTrueName() {
         assertTrue(secondBook.matches("Заводной апельсин"));
    }

    @Test
    void shouldMatchesFalseName() {
        assertFalse(secondBook.matches("апельсин"));
    }

    @Test
    void shouldMatchesTrueAuthor() {
        assertTrue(secondBook.matches("Энтони Бёрджесс"));
    }

    @Test
    void shouldMatchesFalseAuthor() {
        assertFalse(secondBook.matches("Бёрджесс"));
    }
}