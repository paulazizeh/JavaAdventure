package edu.cscc.javaadventure.engine.combat;

import edu.cscc.javaadventure.Weapon;
import edu.cscc.javaadventure.engine.InvalidRollException;

/**
 * This interface is used in combat situations in order to hide the
 * underlying implementations of the combatants. It allows JavaAdventure
 * the flexibility to have many different kinds of combatants.
 */
public interface Combatant extends Comparable<Combatant> {

    /**
     * Attack another combatant. Success and damage of the attack is based
     * on the implementation of the interface.
     * @param roll Represents a die roll which determines if the attack was successful or not.
     * @param combatant The target combatant to be attacked.
     * @return A description of the attack.
     * @throws OpponentIncapacitatedException When the opponent is already incapacitated and cannot fight anymore.
     * @throws InvalidRollException When the die roll is invalid or out of the allowed bounds.
     */
    String attack(int roll, Combatant combatant) throws OpponentIncapacitatedException, InvalidRollException;

    /**
     * Initiative represents the order in which combatants can act in a turn-based game. A lower initiative
     * is better, meaning the combatant can act before other combatants can act.
     * @param roll The roll value used when determining initiative.
     * @throws InvalidRollException When the die roll is invalid or out of the allowed bounds.
     */
    void calculateInitiative(int roll) throws InvalidRollException;

    /**
     * Allows a combatant to equip a weapon for increased damage or other effects.
     * @param weapon The {@link Weapon} to be equipped.
     * @throws UnableToWieldWeaponException When the combatant cannot equip the weapon for various reasons.
     */
    void equipWeapon(Weapon weapon) throws UnableToWieldWeaponException;

    /**
     * Gets the {@link Weapon} the combatant is currently equipped with.
     * @return The weapon.
     */
    Weapon getWeapon();

    /**
     * Gets the current initiative of the combatant. See {@link #calculateInitiative(int).}
     * @return
     */
    int getInitiative();

    /**
     * Armor class represents the combatant's ability to defend themselves. Generally a higher
     * armor class is better.
     * @return The current armor class of the Combatant.
     */
    Integer getArmorClass();

    /**
     * Get the combatant's current health.
     * @return The combatant's current health.
     */
    Integer getHealth();

    /**
     * Allows the combatant to take damage, which reduces their health.
     * @param damage The amount of damage.
     */
    void receiveDamage(int damage);

    /**
     * Indicates if the combatant can still fight or not. Generally this is based on the combatant's health,
     * but could be implemented differently for different reasons.
     * @return true if the combatant can still fight, false otherwise.
     */
    boolean isActiveCombatant();

    /**
     * Gets the name of the combatant.
     * @return The name of the combatant.
     */
    String getName();
}
