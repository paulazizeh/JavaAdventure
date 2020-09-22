package edu.cscc.javaadventure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BackpackTest {

    private Backpack backpack;

    @BeforeEach
    void setUp() {
        backpack = new Backpack();
    }

    @Test
    void getWeight() {
        assertEquals(1.00, backpack.getWeight());
    }

    @Test
    void getName() {
        assertEquals("Backpack", backpack.getName());
    }

    @Test
    void getContents() {
        assertEquals(new ArrayList<JAObject>(), backpack.getContents());
    }

    @Test
    void addObject() {
        JAObject object = new JAObject("object", "leather object", 1.0);
        assertEquals(true, backpack.addObject(object));
    }

    @Test
    void removeObject() {
        JAObject object = new JAObject("object", "leather object", 1.0);
        backpack.addObject(object);
        assertEquals(object, backpack.removeObject(object.getName()));
    }

    @Test
    void setName() {
        backpack.setName("Backpack");
        assertEquals("Backpack", backpack.getName());
    }

    @Test
    void getDescription() {
        assertEquals("A sturdy leather backpack.", backpack.getDescription());
    }

    @Test
    void setDescription() {
        backpack.setDescription("A sturdy leather backpack.");
        assertEquals("A sturdy leather backpack.", backpack.getDescription());
    }
}