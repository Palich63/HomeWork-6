package ru.netology.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotFoundExceptionTest {

    private NotFoundException exception = new NotFoundException();

    @Test
    void shouldthrowChecked() {
        assertThrows(RuntimeException.class, ()->exception.throwChecked());
    }
}