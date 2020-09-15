package edu.cscc.javaadventure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TreasureChestTest {

    private TreasureChest treasureChest;

    @BeforeEach
    void setUp() {
        treasureChest = new TreasureChest();
    }

    @Test
    void getWeight() {
        assertEquals(10.0, treasureChest.getWeight());
    }

    @Test
    void isOpen() {
        assertEquals(false, treasureChest.isOpen());
    }

    @Test
    void isLocked() {
        assertEquals(true, treasureChest.isLocked());
    }

    @Test
    void lock() {
        treasureChest.lock();
        assertEquals(false, treasureChest.isOpen());
        assertEquals(true, treasureChest.isLocked());
    }

    @Test
    void unlock() {
        treasureChest.unlock();
        assertEquals(false, treasureChest.isOpen());
        assertEquals(false, treasureChest.isLocked());
    }

    @Test
    void open() {
        assertEquals(false, treasureChest.open());
        treasureChest.unlock();
        assertEquals(true, treasureChest.open());
    }

    @Test
    void close() {
        treasureChest.close();
        assertEquals(false, treasureChest.open());

    }

    @Test
    void getDescription() {
        assertEquals("A sturdy iron chest. It is locked.",  treasureChest.getDescription());
        treasureChest.unlock();
        assertEquals("A sturdy iron chest. It is unlocked.", treasureChest.getDescription());
    }
}