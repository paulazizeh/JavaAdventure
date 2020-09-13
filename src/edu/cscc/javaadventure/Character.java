package edu.cscc.javaadventure;

public class Character {
    private int health;
    private String name;
    private String description;

    public Character(int health, String name, String description) {
        this.health = health;
        this.name = name;
        this.description = description;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
