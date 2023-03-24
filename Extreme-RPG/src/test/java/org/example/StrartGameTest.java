package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrartGameTest {

    @Test
    public void getName() {
        StrartGame meno = new StrartGame("Ondrej");

        assertEquals(meno.getName(), "Ondrej");
    }


}