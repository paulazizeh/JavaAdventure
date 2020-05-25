package edu.cscc.javaadventure;

public class Sword extends JAObject {

    private Integer damage;
    private Boolean twoHanded;

    Sword() {
        super("Sword", "A razor sharp broadsword forged from dark steel", 8.0);
        this.damage = 10;
        this.twoHanded = true;
    }

    @Override
    protected void setupDescriptionModifiers() {
        //Do nothing.
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Boolean getTwoHanded() {
        return twoHanded;
    }

    public void setTwoHanded(Boolean twoHanded) {
        this.twoHanded = twoHanded;
    }
}
