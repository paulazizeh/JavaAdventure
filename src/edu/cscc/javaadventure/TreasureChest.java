package edu.cscc.javaadventure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a treasure chest in a role-playing game.
 * The treasure chst can be locked or unlocked, and open or unopened.
 * A locked chest must be unlocked before it can be opened. Locking a chest
 * also closes it.
 * A treasure chest also has a weight and a description. The description is
 * different depending on if the chest is locked or not.
 */
public class TreasureChest {
    private double weight;
    private boolean open;
    private boolean locked;

    private List<JAObject> chestContents;

    /**
     * Constructs a TreasureChest. A treasure chest has a default weight
     * and is locked and closed by default.
     */
    public TreasureChest() {
        this.chestContents = new ArrayList<>();
        this.locked = true;
    }

    /**
     * Returns the weight of the treasure chest.
     * @return The weight of the treasure chest to a precision of two decimal places.
     */
    public double getWeight() {
        Iterator<JAObject> chestContentsIterator = chestContents.iterator();
        this.weight = 0;
        while (chestContentsIterator.hasNext()) {
            JAObject jaObject = chestContentsIterator.next();
            this.weight += jaObject.getWeight();
        }
        return weight;
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
     */
    public void lock() {
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
     * @return true if the chest is unlocked, false otherwise.
     */
    public boolean open() {
        if (this.locked) {
            return false;
        }

        this.open = true;

        return this.open;
    }

    /**
     * Closes the chest.
     * Notes: This method does *not* also lock the chest.
     */
    public void close() {
        this.open = false;
    }

    public boolean addObject(JAObject object) {
        return chestContents.add(object);
    }

    public JAObject removeObject(String name) {
        Iterator<JAObject> chestContentsIterator = chestContents.iterator();
        while (chestContentsIterator.hasNext()) {
            JAObject jaObject = chestContentsIterator.next();
            if(jaObject.getName() .equals(name)) {
                chestContents.remove(jaObject);
                return jaObject;
            }
        }
        return null;
    }

    public List<JAObject> getContents() {
        return chestContents;
    }

    /**
     * Retrieves the description of the chest.
     * @return The description of the chest, which is based on whether it is locked or not.
     */
    public String getDescription() {
        return "A sturdy iron chest. " + getLockDescription();
    }

    private String getLockDescription() {
        return this.locked ? "It is locked." : "It is unlocked.";
    }
}
