package edu.cscc.javaadventure;

/**
 * Represents a lantern in a role-playing game.
 * The lantern can be lit or extinguished, broken or fixed.
 * It also has a weight and a description.
 */
public class Lantern extends JAObject {
    private boolean lit;
    private boolean broken;

    /**
     * Constructs the lantern.
     * By default the lantern is unlit, unbroken, and has a weight of 1.50.
     */
    public Lantern() {
        super(null, null, 1.5);
    }

    /**
     * Indicates of the lantern is lit or not.
     * @return true if lit, false otherwise.
     */
    public boolean isLit() {
        return lit;
    }

    /**
     * Lights the lantern.
     */
    public void light() {
        this.lit = true;
    }

    /**
     * Extinguishes the lantern.
     */
    public void extinguish() {
        this.lit = false;
    }

    // Mandatory implementation of the abstract method
    // on JAObject. This method looks at the state of
    // the lantern (lit or unlit) and builds
    // the descriptionModifiers HashMap. The getDescription()
    // method on JAObject relies on this method to generate
    // an accurate description.
    public void setupDescriptionModifiers() {
        // String Constants
        String litModifierKey = "LITMODIFIER";
        String litModifierValue = "It glows softly.";
        String unlitModifierKey = "UNLITMODIFIER";
        String unlitModifierValue = "It is unlit.";

        this.clearDescriptionModifiers();

        if (this.isLit()) {
            this.addDescriptionModifier(litModifierKey, litModifierValue);
        } else {
            this.addDescriptionModifier(unlitModifierKey, unlitModifierValue);
        }
    }

    /**
     * Indicates of the lantern is broken or not.
     * @return true if the lantern is broken, false otherwise.
     */
    public boolean isBroken() {
        return broken;
    }

    /**
     * Repairs the lantern.
     */
    public void fix() {
        this.broken = false;
    }

    /**
     * Breaks the lantern.
     * NOTE: "break" is a keyword in Java, so we can't call this method "break".
     */
    public void makeBroken() {
        this.broken = true;
    }
}
