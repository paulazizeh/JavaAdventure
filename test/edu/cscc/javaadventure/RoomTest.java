package edu.cscc.javaadventure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    private Room room;

    @BeforeEach
    public void setUp() {
        room = new Room("Dungeon", "Dark Dungeon");
    }

    @Test
    void connectRoom() {
        Room newRoom = new Room("Courtyard", "North Courtyard");
        room.connectRoom("Down", newRoom);
        assertEquals(newRoom, room.getRoom("Down"));
    }

    @Test
    void disconnectRoom() {
        Room newRoom = new Room("Courtyard", "North Courtyard");
        room.connectRoom("Down", newRoom);
        room.disconnectRoom("Down");
        assertEquals(null, room.getRoom("Down"));
    }

    @Test
    void getRoom() {
        assertEquals(null, room.getRoom("Down"));
    }

    @Test
    void addToContents() {
        JAObject jaobject = new JAObject("Axe", "Mighty Axe", 20.0);
        room.addToContents(jaobject);
        assertEquals(true, room.listContents().contains("Axe"));
    }

    @Test
    void removeFromContents() {
        JAObject jaobject = new JAObject("Axe", "Mighty Axe", 20.0);
        room.addToContents(jaobject);
        room.removeFromContents("Axe");
        assertEquals(false, room.listContents().contains("Axe"));
    }

    @Test
    void listContents() {
        assertEquals(false, room.listContents().contains("Axe"));
    }

    @Test
    void getDescription() {
        assertEquals("Dark Dungeon", room.getDescription());
    }
}