package edu.cscc.javaadventure.commands;

import edu.cscc.javaadventure.engine.GameState;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class encapsulates the various commands that a user may take.
 */
public class Commands {

    private static Map<String, Command> commands;
    public static List<String> VALID_COMMANDS = new ArrayList<>();

    static {
        commands = buildCommands();
        /*
         * TODO Add valid command names to the VALID_COMMANDS list here.
         * VALID_COMMANDS.add(...);
         */
    }

    /**
     * TODO Complete this method per the requirements.
     * Build a {@link Map} of {@link Command}s keyed by the command string.
     * @return
     */
    private static Map<String, Command> buildCommands() {
        //Do not use anonymous, inner, abstract, or subclasses when building a command.
        //To receive full credit you *must* add a command as a lambda.
        return null;
    }

    /**
     * Retrieve a {@link Command} based on a valid command string.
     * @param commandString The full command string to match. An actual command
     *                      will always be the first part of the string, with the
     *                      remaining part of the string being any arguments
     *                      to the actual {@link Command} object.
     * @return The {@link Command} matching the command string. If a command
     * does not exist return a command that prints "Not a valid command" and returns the {@link edu.cscc.javaadventure.engine.GameState}
     * in its {@link Command#execute(GameState, CommandPrinter, String)} method.
     */
    public static Command getCommand(String commandString) {
        //TODO Complete this method per the requirements.
        return null;
    }

    /**
     * Get the map of {@link Command}s.
     * @return The map of commands keyed by command string.
     */
    public static Map<String, Command> getCommands() {
        return commands;
    }
}
