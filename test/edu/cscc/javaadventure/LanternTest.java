package edu.cscc.javaadventure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanternTest {

    private Lantern lantern;

    @BeforeEach
    void setUp() {
        lantern = new Lantern();
    }

    @Test
    void isLit() {
        assertEquals(false, lantern.isLit());
    }

    @Test
    void light() {
        lantern.light();
        assertEquals(true, lantern.isLit());
    }

    @Test
    void extinguish() {
        lantern.extinguish();
        assertEquals(false, lantern.isLit());
    }

    @Test
    void getDescription() {
        lantern.extinguish();
        assertEquals("A tarnished, old lantern that has seen better days. It is unlit.",  lantern.getDescription());
        lantern.light();
        assertEquals("A tarnished, old lantern that has seen better days. It glows softly.", lantern.getDescription());
    }

    @Test
    void getWeight() {
        assertEquals(1.50, lantern.getWeight());
    }

    @Test
    void isBroken() {
        assertEquals(false, lantern.isBroken());
    }

    @Test
    void fix() {
        lantern.fix();
        assertEquals(false, lantern.isBroken());
    }

    @Test
    void makeBroken() {
        lantern.makeBroken();
        assertEquals(true, lantern.isBroken());
    }
}
