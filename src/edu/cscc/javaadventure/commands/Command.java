package edu.cscc.javaadventure.commands;

import edu.cscc.javaadventure.engine.GameState;

/**
 * A command to be executed by the user.
 */
public interface Command {

    /**
     * Executes the given command and creates a new GameState based on the result.
     * @param gameState The current {@link GameState} object.
     * @param commandFailure {@link CommandFailure} function to handle a command failure.
     * @return The new GameState created by executing the command.
     */
    GameState execute(GameState gameState, CommandFailure commandFailure);
}
