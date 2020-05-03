package edu.cscc.javaadventure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartyTest {

    private Party party;

    @BeforeEach
    public void setUp() {
        party = new Party();
    }

    @Test
    public void itHasNoMembersWhenInitialized() {
        assertEquals(0, party.size());
        assertTrue(party.getMembers().isEmpty());
    }

    @Test
    public void itCanAddAMember() {
        Character character = new Character("Gandalf");

        party.addMember(character);

        assertEquals(1, party.size());
        assertTrue(party.getMembers().contains(character));
    }

    @Test
    public void itCanAddMultipleMembers() {
        Character character = new Character("Gandalf");
        Character secondCharacter = new Character("Gimli");

        party.addMember(character);
        party.addMember(secondCharacter);

        assertEquals(2, party.size());
        assertTrue(party.getMembers().contains(character));
        assertTrue(party.getMembers().contains(secondCharacter));
    }

    @Test
    public void itCanRemoveAMemberByName() {
        Character character = new Character("Gandalf");
        party.addMember(character);

        assertEquals(character, party.removeMember("Gandalf"));
    }

    @Test
    public void itReturnsNullWhenItCannotRemoveAMember() {
        assertNull(party.removeMember("Gandalf"));
    }

    @Test
    public void itCanFindAMemberByName() {
        Character character = new Character("Gandalf");
        party.addMember(character);

        assertEquals(character, party.findMember("Gandalf"));
    }

    @Test
    public void itReturnsNullWhenItCannotFindAMemberByName() {
        assertNull(party.findMember("Gandalf"));
    }
}