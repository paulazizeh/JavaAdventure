package edu.cscc.javaadventure;

import edu.cscc.javaadventure.engine.InvalidRollException;
import edu.cscc.javaadventure.engine.combat.Combatant;
import edu.cscc.javaadventure.engine.combat.Goblin;
import edu.cscc.javaadventure.engine.combat.UnableToWieldWeaponException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCombatantTest {

    private CharacterCombatant characterCombatant;

    @BeforeEach
    void setUp() {
        Character character = new Character();
        character.setName("Paul");
        character.setHealth(10);
        character.setDexterity(10);
        character.setStrength(10);
        characterCombatant = new CharacterCombatant(character);
    }

    @Test
    void getName() {
        assertEquals("Paul", characterCombatant.getName());
    }

    @Test
    void getHealth() {
        assertEquals(10, characterCombatant.getHealth());
    }

    @Test
    void getInitiative() {
        assertEquals(0, characterCombatant.getInitiative());
    }

    @Test
    void calculateInitiative() {
        assertThrows(InvalidRollException.class, () -> characterCombatant.calculateInitiative(0));
    }

    @Test
    void getArmorClass() {
        assertEquals(10, characterCombatant.getArmorClass());
    }

    @Test
    void equipWeapon() throws UnableToWieldWeaponException {
        Sword twoHandedSword = new Sword();
        twoHandedSword.setTwoHanded(true);
        assertThrows(UnableToWieldWeaponException.class, () -> characterCombatant.equipWeapon(twoHandedSword));
    }

    @Test
    void receiveDamage() {
        characterCombatant.receiveDamage(5);
        assertEquals(5, characterCombatant.getHealth());
    }

    @Test
    void isActiveCombatant() {
        assertEquals(true, characterCombatant.isActiveCombatant());
    }

    @Test
    void getWeapon() throws UnableToWieldWeaponException {
        Sword oneHandedSword = new Sword();
        oneHandedSword.setTwoHanded(false);
        characterCombatant.equipWeapon(oneHandedSword);
        assertEquals("Sword", characterCombatant.getWeapon().getName());
    }

    @Test
    void attack() {
        Character character2 = new Character();
        CharacterCombatant characterCombatant2 = new CharacterCombatant(character2);
        assertThrows(InvalidRollException.class, () -> characterCombatant.attack(21, characterCombatant2));

    }

    @Test
    void compareTo() {
    }
}