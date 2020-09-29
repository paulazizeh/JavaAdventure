package edu.cscc.javaadventure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Room {
    private String name;
    private String description;
    HashMap<String, Room> rooms = new HashMap<String, Room>();
    HashMap<String, JAObject> contents = new HashMap<String, JAObject>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void connectRoom(String direction, Room targetRoom) {
        rooms.put(direction, targetRoom);
    }

    public void disconnectRoom(String direction) {
        rooms.remove(direction);
    }

    public Room getRoom(String direction) {
        return rooms.get(direction);

    }

    public void addToContents(JAObject jaObject) {
        contents.put(jaObject.getName(), jaObject);
    }

    public JAObject removeFromContents(String name) {
        return contents.remove(name);

    }

    public Set<String> listContents() {
        return contents.keySet();

    }

    public String getDescription() {
        String roomDescription = description;
        if (!contents.isEmpty()) {
            roomDescription += "\nContents are";
            Iterator<String> listContents = listContents().iterator();
            while (listContents.hasNext()) {
                String contents = listContents.next();
                roomDescription += "\n";
                roomDescription += contents;
                roomDescription += " is here";
            }

        }

        if (!rooms.isEmpty()) {
            roomDescription += "\nExits are";
            Iterator<String> getRoom = rooms.keySet().iterator();
            while (getRoom.hasNext()) {
                String roomDirection = getRoom.next();
                roomDescription += "\n";
                roomDescription += roomDirection;
            }
        }
        return roomDescription;
    }

}
