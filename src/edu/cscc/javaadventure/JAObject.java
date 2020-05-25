package edu.cscc.javaadventure;

import java.util.Objects;
import java.util.UUID;

/**
 * Represents a generic object in the Java Adventure game.
 */
public abstract class JAObject {

    protected String name;
    protected String description;
    protected Double weight;
    protected UUID uuid;

    public JAObject() {
        this.uuid = UUID.randomUUID();
    }

    /**
     * Construct a new JAObject.
     * @param name The name of the object.
     * @param description The description of the object.
     * @param weight The weight of the object.
     */
    public JAObject(String name, String description, Double weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.uuid = UUID.randomUUID();
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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
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

    public UUID getUuid() {
        return uuid;
    }
}
