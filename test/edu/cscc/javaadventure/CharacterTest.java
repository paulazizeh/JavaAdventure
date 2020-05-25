package edu.cscc.javaadventure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    private Character character;

    @BeforeEach
    void setUp() {
        character = new Character("Radagast","The Brown Wizard", 100, "male", 10, 12,
                11, 16, 18, 12, 35, 5.0);
    }

    @Test
    void initializationWithNoValues() {
        character = new Character();
        assertNotNull(character);

        assertNull(character.getName());
        assertNull(character.getDescription());
        assertNull(character.getAge());
        assertNull(character.getGender());
        assertNull(character.getStrength());
        assertNull(character.getDexterity());
        assertNull(character.getConstitution());
        assertNull(character.getIntelligence());
        assertNull(character.getWisdom());
        assertNull(character.getCharisma());
    }

    @Test
    void getName() {
        assertEquals("Radagast", character.getName());
    }

    @Test
    void setName() {
        character.setName("Gandalf");

        assertEquals("Gandalf", character.getName());
    }

    @Test
    void getDescription() {
        assertEquals("The Brown Wizard", character.getDescription());
    }

    @Test
    void setDescription() {
        character.setDescription("The Gray Wizard");

        assertEquals("The Gray Wizard", character.getDescription());
    }

    @Test
    void getAge() {
        assertEquals(100, character.getAge());
    }

    @Test
    void setAge() {
        character.setAge(1000);

        assertEquals(1000, character.getAge());
    }

    @Test
    void getGender() {
        assertEquals("male", character.getGender());
    }

    @Test
    void setGender() {
        character.setGender("Maiar");

        assertEquals("Maiar", character.getGender());
    }

    @Test
    void getStrength() {
        assertEquals(10, character.getStrength());
    }

    @Test
    void setStrength() {
        character.setStrength(11);

        assertEquals(11, character.getStrength());
    }

    @Test
    void getDexterity() {
        assertEquals(12, character.getDexterity());
    }

    @Test
    void setDexterity() {
        character.setDexterity(13);

        assertEquals(13, character.getDexterity());
    }

    @Test
    void getConstitution() {
        assertEquals(11, character.getConstitution());
    }

    @Test
    void setConstitution() {
        character.setConstitution(12);

        assertEquals(12, character.getConstitution());
    }

    @Test
    void getIntelligence() {
        assertEquals(16, character.getIntelligence());
    }

    @Test
    void setIntelligence() {
        character.setIntelligence(18);

        assertEquals(18, character.getIntelligence());
    }

    @Test
    void getWisdom() {
        assertEquals(18, character.getWisdom());
    }

    @Test
    void setWisdom() {
        character.setWisdom(20);

        assertEquals(20, character.getWisdom());
    }

    @Test
    void getCharisma() {
        assertEquals(12, character.getCharisma());
    }

    @Test
    void setCharisma() {
        character.setCharisma(11);

        assertEquals(11, character.getCharisma());
    }

    @Test
    void getHealth() {
        assertEquals(35, character.getHealth());
    }

    @Test
    void setHealth() {
        character.setHealth(45);

        assertEquals(45, character.getHealth());
    }
}