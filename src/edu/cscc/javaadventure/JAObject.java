package edu.cscc.javaadventure;

import com.sun.org.apache.bcel.internal.generic.MONITORENTER;

import java.util.HashMap;
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
    protected HashMap<ModifierName, String> descriptionModifiers;

    public JAObject() {
        this.uuid = UUID.randomUUID();
        descriptionModifiers = new HashMap<>();
    }

    public enum ModifierName {
        OPEN_MODIFIER,
        CLOSED_MODIFIER,
        LOCKED_MODIFIER,
        UNLOCKED_MODIFIER,
        LIT_MODIFIER,
        UNLIT_MODIFIER
    }

    protected abstract void setupDescriptionModifiers();

    // Add a description modifier entry to the HashMap
    public void addDescriptionModifier(ModifierName modifierName, String modifierValue) {
        this.descriptionModifiers.put(modifierName, modifierValue);
    }
    // Remove a description modifier entry from the HashMap
    public void removeDescriptionModifier(ModifierName modifierName) {
        this.descriptionModifiers.remove(modifierName);
    }
    // Clear the description modifier HashMap of all entries
    public void clearDescriptionModifiers() {
        this.descriptionModifiers.clear();
    }

    // Any class which extends JAObject must implement setupModifiers
    // This function asks the object to generate a collection of
    // description modifiers based on its state (such as open or closed,
    // lit or unlit, etc). The getDescription method then appends those
    // description modifiers to the base description, generating a
    // complete description of the object.
    public String getDescription() {
        setupDescriptionModifiers();

        // The full description begins as being the same as the base description
        String fullDescription = this.description;

        // For each key in the descriptionModifiers HashMap, retrieve the
        // value. Those values are modifiers to the description such as
        // "It is lit." Append all the modifiers to the base description
        // making sure to include a space between each one.
        for (ModifierName modifierKey : this.descriptionModifiers.keySet()) {
            fullDescription += " " + this.descriptionModifiers.get(modifierKey);
        }

        return fullDescription;
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
