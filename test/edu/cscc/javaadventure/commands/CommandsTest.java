package edu.cscc.javaadventure.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandsTest {

   private Commands commands;


    @Test
    void getCommand() {
        assertNotNull(Commands.getCommand("look"));
        assertNotNull(Commands.getCommand("exit"));
        assertNotNull(Commands.getCommand("north"));
        assertNotNull(Commands.getCommand("south"));
        assertNotNull(Commands.getCommand("up"));
        assertNotNull(Commands.getCommand("down"));
        assertNotNull(Commands.getCommand("east"));
        assertNotNull(Commands.getCommand("west"));
    }

    @Test
    void getCommands() {
        assertEquals(8, Commands.getCommands().size());
    }
}