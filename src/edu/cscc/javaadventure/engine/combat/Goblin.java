package edu.cscc.javaadventure.engine.combat;

import edu.cscc.javaadventure.JAObject;
import edu.cscc.javaadventure.MovableObject;
import edu.cscc.javaadventure.Weapon;
import edu.cscc.javaadventure.engine.InvalidRollException;

public class Goblin extends MovableObject implements Combatant {
    private String name;
    private String description;
    private Integer health;
    private int initiative;
    private Weapon weapon;

    public Goblin() {
    this.name = "Goblin";
    this.description = "A green-skinned humanoid with an evil gleam in their eyes.";
    this.health = 10;
    this.initiative = 0;
    this.weapon = new Spear();
    }

    @Override
    protected void setupDescriptionModifiers() {

    }

    public String getName(){
        return name;
    }

    public Integer getHealth(){
    return health;
    }

    public int getInitiative(){
    return this.initiative;
    }


    //In the lab doc, it states "If the initiative is less than 1 then set the initiative to 1, otherwise set the initiative to the calculated initiative."
    //I think we already have it set within the IF statement.
    public void calculateInitiative(int roll)  throws InvalidRollException {
        if(roll < 1 || roll > 10) {
            throw new InvalidRollException("This number is " + roll + "which is invalid");
        }
        this.initiative = roll;
    }

    @Override
    public void equipWeapon(Weapon weapon) throws UnableToWieldWeaponException {
        throw new UnableToWieldWeaponException("Goblins can't handle other weapons");
    }

    @Override
    public Integer getArmorClass() {
    return 7;
    }

    public void receiveDamage(int damage) {
    this.health = this.health - damage;
    }

    public boolean isActiveCombatant() {
        if (this.getHealth() > 0) {
            return true;
        }
        return false;
    }

    public Weapon getWeapon() {
    return this.weapon;
    }

    @Override
    public String attack(int roll, Combatant combatant) throws InvalidRollException, OpponentIncapacitatedException {
        if(roll < 1 || roll > 20) {
            throw new InvalidRollException("Missed");
        }
        if(combatant.isActiveCombatant() == false) {
            throw new OpponentIncapacitatedException("Opponent is dead");
        }
        if(roll >= combatant.getArmorClass()) {
            combatant.receiveDamage(weapon.getDamage());
            return name + " attacks " + combatant.getName() + " with " + weapon.getName() + " and deals " + weapon.getDamage() + " points of damage.";
        }
        else {
            return name + " attacks " + combatant.getName() + " with "  + weapon.getName() + " and misses! ";
        }
    }

    @Override
    public int compareTo(Combatant o) {
        return 0;
    }

    protected static class Spear extends JAObject implements Weapon {

        public Spear() {
            super("A crude spear", "It’s a pointy stick", 3.0);
        }

        @Override
        protected void setupDescriptionModifiers() {

        }

        @Override
        public Integer getDamage() {
            return 3;
        }

        @Override
        public Boolean getTwoHanded() {
            return false;
        }
    }
}
