package edu.cscc.javaadventure;

/**
 * Represents a treasure chest in a role-playing game.
 * The treasure chst can be locked or unlocked, and open or unopened.
 * A locked chest must be unlocked before it can be opened. Locking a chest
 * also closes it.
 * A treasure chest also has a weight and a description. The description is
 * different depending on if the chest is locked or not.
 */
public class TreasureChest extends JAObject {
    private boolean open;
    private boolean locked;

    /**
     * Constructs a TreasureChest. A treasure chest has a default weight
     * and is locked and closed by default.
     */
    public TreasureChest() {
        super(null, null, 10.00);
        this.locked = true;
    }

    public void setupDescriptionModifiers() {
        // String Constants
        String openModifierValue = "It lies open.";
        String closedModifierValue = "It is closed.";
        String lockedModifierValue = "It is tightly locked.";
        String unlockedModifierValue = "It is unlocked.";

        this.clearDescriptionModifiers();

        if (this.isOpen()) {
            this.addDescriptionModifier(ModifierName.OPEN_MODIFIER, openModifierValue);
        } else {
            this.addDescriptionModifier(ModifierName.CLOSED_MODIFIER, closedModifierValue);
        }

        if (this.isLocked()) {
            this.addDescriptionModifier(ModifierName.LOCKED_MODIFIER, lockedModifierValue);
        } else {
            this.addDescriptionModifier(ModifierName.UNLOCKED_MODIFIER, unlockedModifierValue);
        }
    }


    /**
     * Indicates if the treasure chest is open or not.
     * @return true if it is open (which also implies it is unlocked), false otherwise.
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * Indicates if the treasure chest is locked or not.
     * @return true if the chest is locked, false otherwise.
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * Locks the chest. It also closes the chest if it was open.
     * @throws ChestLockedException if the chest is already locked.
     */
    public void lock() throws ChestLockedException {
        if (this.locked) {
            throw new ChestLockedException();
        }
        this.locked = true;
        this.close();
    }

    /**
     * Unlocks the chest.
     * Note, this method does *not* open the chest.
     */
    public void unlock() {
        this.locked = false;
    }

    /**
     * Opens the chest if it is unlocked.
     * @throws ChestLockedException if the chest is locked.
     * @throws ChestAlreadyOpenException if the chest is already open
     */
    public void open() throws ChestLockedException, ChestAlreadyOpenException {
        if (this.open) {
            throw new ChestAlreadyOpenException();
        }

        if (this.locked) {
            throw new ChestLockedException();
        }

        this.open = true;
    }

    /**
     * Closes the chest.
     * Notes: This method does *not* also lock the chest.
     */
    public void close() {
        this.open = false;
    }
}
