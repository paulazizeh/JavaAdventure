package edu.cscc.javaadventure.commands;

import edu.cscc.javaadventure.engine.GameState;
import edu.cscc.javaadventure.engine.GetUserCommand;

/**
 * A command to be executed by the user. The command will accept a {@link GameState},
 * a {@link CommandPrinter} object used to print messages for the game, and a command
 * string provided by the user. The command will perform whatever logic is assigned to
 * it based on these inputs, and will produce a new GameState object to be used in the
 * next tick of {@link edu.cscc.javaadventure.engine.GameEngine}.
 */
public interface Command {

    /**
     * Executes the given command and creates a new GameState based on the result.
     * @param gameState The {@link GameState} that the command will be executed against.
     * @param commandPrinter The {@link CommandPrinter} functional interface to print messages for the game.
     * @param commandString The full command string, which is the user entered command. This command string
     *                      will include the actual command at the beginning of the String. Anything after that
     *                      should be consider the arguments to the specific command.
     * @return A new {@link GameState} object which will be used in the next {@link edu.cscc.javaadventure.engine.GameEngine#tick(GameState, GetUserCommand, CommandPrinter)} execution.
     */
    GameState execute(GameState gameState, CommandPrinter commandPrinter, String commandString);
}
