package edu.cscc.javaadventure.engine.combat;

/**
 * Exception thrown when a {@link Combatant fails to equip a two-handed weapon.}
 */
public class UnableToWieldWeaponException extends Exception {
    public UnableToWieldWeaponException(String message) {
        super(message);
    }
}
