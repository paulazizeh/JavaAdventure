package edu.cscc.javaadventure;

import java.util.*;

/**
 * Represents a party of adventures in the JavaAdventure game.
 * Party can add, remove, find, and get members, as well as determining the size
 * of the party. Party members must have unique names.
 */
public class Party implements Iterable<Character> {
    private HashMap<String, Character> members;

    public Party() {
        members = new HashMap<>();
    }

    /**
     * Adds a character as a member.
     * Character will not be added if it is not unique.
     * @param character
     */
    public void addMember(Character character) {
        members.put(character.getName(), character);
    }

    /**
     * Removes a member by name.
     * @param name The name of the member.
     * @return The removed member, or null if they are not in the party.
     */
    public Character removeMember(String name) {
        return members.remove(name);
    }

    /**
     * Returns the count of party members.
     * @return The number of members in the party.
     */
    public Integer size() {
        return members.size();
    }

    /**
     * Find a member by name.
     * @param name The name of the member to find.
     * @return The found member, or null if they could not be found.
     */
    public Character findMember(String name) {
        return members.get(name);
    }

    /**
     * Get the members of the party as a list.
     * @return A List of Characters who are members of the party.
     */
    public List<Character> getMembers() {
        ArrayList<Character> characters = new ArrayList<>();
        characters.addAll(members.values());

        return characters;
    }

    @Override
    public Iterator<Character> iterator() {
        return members.values().iterator();
    }
}
