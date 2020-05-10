package edu.cscc.javaadventure;

import java.util.*;

/**
 * Represents a party of adventures in the JavaAdventure game.
 * Party can add, remove, find, and get members, as well as determining the size
 * of the party. Party members must have unique names.
 */
public class Party {
    private HashSet<Character> members;

    public Party() {
        members = new HashSet<>();
    }

    /**
     * Adds a character as a member.
     * Character will not be added if it is not unique.
     * @param character
     */
    public void addMember(Character character) {
        members.add(character);
    }

    /**
     * Removes a member by name.
     * @param name The name of the member.
     * @return The removed member, or null if they are not in the party.
     */
    public Character removeMember(String name) {
        for (Character member : members) {
            if (name.equals(member.getName())) {
                members.remove(member);
                return member;
            }
        }

        return null;
    }

    /**
     * Returns the count of party members.
     * @return The number of members in the party.
     */
    public int size() {
        return members.size();
    }

    /**
     * Find a member by name.
     * @param name The name of the member to find.
     * @return The found member, or null if they could not be found.
     */
    public Character findMember(String name) {
        for (Character member : members) {
            if (name.equals(member.getName())) {
                return member;
            }
        }

        return null;
    }

    /**
     * Get the members of the party as a list.
     * @return A List of Characters who are members of the party.
     */
    public List<Character> getMembers() {
        ArrayList<Character> memberList = new ArrayList<>();
        memberList.addAll(members);

        return memberList;
    }
}
