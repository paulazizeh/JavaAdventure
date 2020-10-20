package edu.cscc.javaadventure.engine;

import edu.cscc.javaadventure.Party;
import edu.cscc.javaadventure.Room;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents the state of the game from one tick to the next.
 * A new game state will be generated on every tick.
 */
public class GameState {
    private final Party party;
    private final Room currentRoom;
    private final boolean isPlaying;


    public GameState(Party party, Room currentRoom, boolean isPlaying) {
        this.party = party;
        this.currentRoom = currentRoom;
        this.isPlaying = isPlaying;
    }

    public Party getParty() {
        return party;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    //TODO Complete this method per the requirements.

    /**
     * Build the description of the game in its current state
     * for the user.
     * @return The description of the game in its current state.
     */
    public String getCurrentDescription() {
        //TODO Complete this method per the requirements.
        String returnDescription = currentRoom.getDescription();

        List<String> getMembers = party.getMembers()
                .stream()
                .map(character -> "\n ".concat(character.getName() + " Is standing here"))
                .collect(Collectors.toList());

        getMembers.forEach(returnDescription::concat);

        return returnDescription;
    }

}
