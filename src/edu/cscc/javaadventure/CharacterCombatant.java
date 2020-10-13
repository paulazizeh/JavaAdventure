package edu.cscc.javaadventure;

import edu.cscc.javaadventure.engine.InvalidRollException;
import edu.cscc.javaadventure.engine.combat.Combatant;
import edu.cscc.javaadventure.engine.combat.UnableToWieldWeaponException;

public class CharacterCombatant implements Combatant {
    private Character j;
    private int initiative;
    private Weapon weapon;

    public CharacterCombatant(Character character) {
        this.j = character;
        this.initiative = 0;
    }

    public String getName(){
        return j.getName();
    }

    public Integer getHealth(){
        return j.getHealth();
    }

    public int getInitiative(){
    return this.initiative;
    }

    public void calculateInitiative(int roll) throws InvalidRollException {
        if(roll < 1 || roll > 10) {
            throw new InvalidRollException("This number is " + roll + "which is invalid");
        }
        this.initiative = roll - (Math.max(j.getDexterity(), 14) - 14);
    }

    @Override
    public Integer getArmorClass() {
        return 10 + (Math.max(j.getDexterity(), 14) - 14);
    }

    @Override
    public void equipWeapon(Weapon weapon) throws UnableToWieldWeaponException {
        if(weapon.getTwoHanded() && j.getStrength() < 15) {
            throw new UnableToWieldWeaponException("Not enough strength");
        }
        this.weapon = weapon;
    }

    public void receiveDamage(int damage) {
        j.setHealth(j.getHealth() - damage);
    }

    public boolean isActiveCombatant() {
        if (j.getHealth() > 0) {
            return true;
        }
        return false;
    }

    public Weapon getWeapon() {
    return weapon;
    }

    public String attack(int roll, Combatant combatant) throws InvalidRollException {
        if(roll < 1 || roll > 20) {
            throw new InvalidRollException("Missed");
        }
        return "Attacked";
    }

    @Override
    public int compareTo(Combatant o) {
        if(this.getName().equals(((CharacterCombatant)o).getName())) {
            return 0;
        } else {
            return -1;
        }
    }
}
