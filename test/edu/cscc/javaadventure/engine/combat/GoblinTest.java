package edu.cscc.javaadventure.engine.combat;

import edu.cscc.javaadventure.engine.InvalidRollException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoblinTest {

    private Goblin goblin;

    @BeforeEach
    void setUp() {
        goblin = new Goblin();
    }

    @Test
    void getName() {
        assertEquals("Goblin", goblin.getName());
    }

    @Test
    void getHealth() {
        assertEquals(10, goblin.getHealth());
    }

    @Test
    void getInitiative() {
        assertEquals(0, goblin.getInitiative());
    }

    @Test
    void calculateInitiative() throws InvalidRollException {
        goblin.calculateInitiative(5);
        assertEquals(5, goblin.getInitiative());
    }

    @Test
    void equipWeapon() {
        assertThrows(UnableToWieldWeaponException.class, () -> goblin.equipWeapon(new Goblin.Spear()));
    }

    @Test
    void getArmorClass() {
        assertEquals(7, goblin.getArmorClass());
    }

    @Test
    void receiveDamage() {
        goblin.receiveDamage(5);
        assertEquals(5, goblin.getHealth());
    }

    @Test
    void isActiveCombatant() {
        assertEquals(true, goblin.isActiveCombatant());
    }

    @Test
    void getWeapon() {
        assertEquals("A crude spear", goblin.getWeapon().getName());
    }

    @Test
    void attack() {
        Goblin goblin2 = new Goblin();
        assertThrows(InvalidRollException.class, () -> goblin.attack(21, goblin2));
    }
}