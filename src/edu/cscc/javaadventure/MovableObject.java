package edu.cscc.javaadventure;

public abstract class MovableObject extends JAObject {
    private Room room;

    public MovableObject(String name, String description, Double weight) {
        super(name, description, weight);
    }

    public MovableObject() {
        super();
    }


    public void setRoom(Room room) {
        this.room = room;
        this.room.addToContents(this);
    }

    public Room getRoom() {
        return room;
    }

    public void move(Direction direction) {
    if(room.getRoom(direction.getDirection()) != null) {
        room.removeFromContents(getName());
        setRoom(room.getRoom(direction.getDirection()));
    }
    }



}