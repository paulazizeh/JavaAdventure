package edu.cscc.javaadventure.engine.combat;

/**
 * Exception thrown during combat when a {@link Combatant} has already
 * been incapacitated and can no longer fight. It can capture a combatant
 * that is no longer active.
 */
public class OpponentIncapacitatedException extends Exception {

    private Combatant combatant;

    public OpponentIncapacitatedException(String message) {
        super(message);
    }

    public OpponentIncapacitatedException(Combatant combatant, String message) {
        super(message);
        this.combatant = combatant;
    }

    public Combatant getCombatant() {
        return combatant;
    }
}
