package edu.cscc.javaadventure.engine;

import edu.cscc.javaadventure.commands.Commands;
import edu.cscc.javaadventure.commands.CommandFailure;

/**
 * GameEngine.tick is a function which gets a command from the user and executes the command
 * to generate a new {@link edu.cscc.javaadventure.engine.GameState}. It passes a function, {@link edu.cscc.javaadventure.commands.CommandFailure},
 * to the {@link edu.cscc.javaadventure.commands.Command} object to be executed if the command fails.
 */
public interface GameEngine {

    /**
     * Advance the game forward by creating a new GameState.
     * @param gameState The current {@link edu.cscc.javaadventure.engine.GameState}.
     * @param getUserCommand A functional interface, to retrieve the user input.
     * @param commandFailure A functional interface, {@link edu.cscc.javaadventure.commands.CommandFailure}, to handle command failure.
     * @return
     */
    static GameState tick(GameState gameState, GetUserCommand getUserCommand, CommandFailure commandFailure) {
        //TODO Complete this method per the requirements
        return null;
    }
}
