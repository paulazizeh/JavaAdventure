package edu.cscc.javaadventure.engine;

import edu.cscc.javaadventure.Party;
import edu.cscc.javaadventure.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {

    private GameState gameState;
    private Party party;
    private Room room;

    @BeforeEach
    void setUp() {
        party = new Party();
        room = new Room("Dungeon", "A Dark Dungeon");
        gameState = new GameState(party, room, true);
    }

    @Test
    void getParty() {
        assertEquals(party, gameState.getParty());
    }

    @Test
    void getCurrentRoom() {
        assertEquals(room, gameState.getCurrentRoom());
    }

    @Test
    void isPlaying() {
        assertEquals(true, gameState.isPlaying());
    }

    @Test
    void getCurrentDescription() {
        assertEquals("A Dark Dungeon\n" +
                "Contents are: \n" +
                "\n" +
                "Exits are: \n", gameState.getCurrentDescription());
    }
}