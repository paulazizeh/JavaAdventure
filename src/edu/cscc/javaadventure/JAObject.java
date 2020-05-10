package edu.cscc.javaadventure;

import java.util.Objects;

/**
 * Represents a generic object in the Java Adventure game.
 */
public class JAObject {

    private String name;
    private String description;
    private double weight;

    /**
     * Construct a new JAObject.
     * @param name The name of the object.
     * @param description The description of the object.
     * @param weight The weight of the object.
     */
    public JAObject(String name, String description, double weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JAObject jaObject = (JAObject) o;
        return Double.compare(jaObject.weight, weight) == 0 &&
                Objects.equals(name, jaObject.name) &&
                Objects.equals(description, jaObject.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, weight);
    }
}
