package edu.cscc.javaadventure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Backpack {
    private double weight;
    private String name;
    private String description;
    private List<JAObject> backpackContents;

    public Backpack() {
        this.name = "Backpack";
        this.description = "A sturdy leather backpack.";
        this.backpackContents = new ArrayList<>();
    }

    public double getWeight() {
        Iterator<JAObject> backpackContentsIterator = backpackContents.iterator();
        this.weight = 1.00;
        while (backpackContentsIterator.hasNext()) {
            JAObject jaObject = backpackContentsIterator.next();
            this.weight += jaObject.getWeight();
        }
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public List<JAObject> getContents() {
        return backpackContents;
    }

    public boolean addObject(JAObject object) {
        return backpackContents.add(object);
    }



    public JAObject removeObject(String name) {
        Iterator<JAObject> backpackContentsIterator = backpackContents.iterator();
        while (backpackContentsIterator.hasNext()) {
            JAObject jaObject = backpackContentsIterator.next();
            if(jaObject.getName() .equals(name)) {
                backpackContents.remove(jaObject);
                return jaObject;
            }
        }
        return null;
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


