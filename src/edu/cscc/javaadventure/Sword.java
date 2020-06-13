package edu.cscc.javaadventure;

public class Sword extends JAObject implements Weapon {

    private Integer damage;
    private Boolean twoHanded;

    //Constructor and other methods...
    Sword() {
        super("Sword", "A razor sharp broadsword forged from dark steel", 8.0);
        this.damage = 10;
        this.twoHanded = true;
    }

    @Override
    protected void setupDescriptionModifiers() {
        //Do nothing.
    }

    @Override
    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    @Override
    public Boolean getTwoHanded() {
        return twoHanded;
    }

    public void setTwoHanded(Boolean twoHanded) {
        this.twoHanded = twoHanded;
    }
}
