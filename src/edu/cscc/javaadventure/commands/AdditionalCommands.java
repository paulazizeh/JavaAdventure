package edu.cscc.javaadventure.commands;

import edu.cscc.javaadventure.JAObject;
import edu.cscc.javaadventure.Party;

import java.util.Optional;

public class AdditionalCommands {

    public static final String TAKE = "take";

    public static void addCommands() {
        Commands.VALID_COMMANDS.add(TAKE);
        Commands.getCommands().put(TAKE,
        (gameState, commandPrinter, commandString) -> {
            String argument = commandString.replace(TAKE, "").trim();
            Optional<String> maybeFound = gameState
                    .getCurrentRoom()
                    .listContents()
                    .stream()
                    .filter(name -> name.equals(argument))
                    .findFirst();
            Party currentParty = gameState.getParty();
            maybeFound.ifPresent(name -> {
                JAObject foundObject = gameState.getCurrentRoom().getObject(name);
                gameState.getParty().memberTake(currentParty.getMembers().get(0).getName(), foundObject);
                gameState.getCurrentRoom().removeFromContents(name);
            });
            return gameState;
        });
    }
}
