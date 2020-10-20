package edu.cscc.javaadventure.commands;

import edu.cscc.javaadventure.engine.GameState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class encapsulates the various commands that a user may take.
 */
public class Commands {

    private static Map<String, Command> commands = new HashMap<>();
    public static List<String> VALID_COMMANDS = new ArrayList<>();

    static {
        commands = buildCommands();

        VALID_COMMANDS.add("look");
        VALID_COMMANDS.add("exit");
        VALID_COMMANDS.add("up");
        VALID_COMMANDS.add("down");
        VALID_COMMANDS.add("north");
        VALID_COMMANDS.add("south");
        VALID_COMMANDS.add("east");
        VALID_COMMANDS.add("west");
    }


    /**
     * TODO Complete this method per the requirements.
     * Build a {@link Map} of {@link Command}s keyed by the command string.
     *
     * @return
     */
    private static Map<String, Command> buildCommands() {
        //Do not use anonymous, inner, abstract, or subclasses when building a command.
        //To receive full credit you *must* add a command as a lambda.
        commands.put("look", new Command() {

            @Override
            public GameState execute(GameState gameState, CommandPrinter commandPrinter, String commandString) {
                if (gameState.getCurrentRoom().getObject(commandString.split("\\s+")[1]) == null) {
                    commandPrinter.printMessage("Object not found");
                } else {
                    commandPrinter.printMessage(gameState.getCurrentRoom().getObject(commandString.split("\\s+")[1]).getDescription());
                }
                return gameState;
            }
        });


        commands.put("exit",new

    Command() {

        @Override
        public GameState execute (GameState gameState, CommandPrinter commandPrinter, String commandString){
            GameState newGameState = new GameState(gameState.getParty(), gameState.getCurrentRoom(), false);
            return newGameState;
        }
    });

        commands.put("up", new Command() {

            @Override
            public GameState execute(GameState gameState, CommandPrinter commandPrinter, String commandString) {
                GameState newGameState = gameState;
                if (gameState.getCurrentRoom().getRoom("up") == null) {
                    commandPrinter.printMessage("You can’t go that way.");
                } else {
                    newGameState = new GameState(gameState.getParty(), gameState.getCurrentRoom().getRoom("up"), true);
                    }
                return newGameState;
            }
        });

        commands.put("down", new Command() {

            @Override
            public GameState execute(GameState gameState, CommandPrinter commandPrinter, String commandString) {
                GameState newGameState = gameState;
                if (gameState.getCurrentRoom().getRoom("down") == null) {
                    commandPrinter.printMessage("You can’t go that way.");
                } else {
                    newGameState = new GameState(gameState.getParty(), gameState.getCurrentRoom().getRoom("down"), true);
                }
                return newGameState;
            }
        });

        commands.put("north", new Command() {

            @Override
            public GameState execute(GameState gameState, CommandPrinter commandPrinter, String commandString) {
                GameState newGameState = gameState;
                if (gameState.getCurrentRoom().getRoom("north") == null) {
                    commandPrinter.printMessage("You can’t go that way.");
                } else {
                    newGameState = new GameState(gameState.getParty(), gameState.getCurrentRoom().getRoom("north"), true);
                }
                return newGameState;
            }
        });

        commands.put("south", new Command() {

            @Override
            public GameState execute(GameState gameState, CommandPrinter commandPrinter, String commandString) {
                GameState newGameState = gameState;
                if (gameState.getCurrentRoom().getRoom("south") == null) {
                    commandPrinter.printMessage("You can’t go that way.");
                } else {
                    newGameState = new GameState(gameState.getParty(), gameState.getCurrentRoom().getRoom("south"), true);
                }
                return newGameState;
            }
        });

        commands.put("east", new Command() {

            @Override
            public GameState execute(GameState gameState, CommandPrinter commandPrinter, String commandString) {
                GameState newGameState = gameState;
                if (gameState.getCurrentRoom().getRoom("east") == null) {
                    commandPrinter.printMessage("You can’t go that way.");
                } else {
                    newGameState = new GameState(gameState.getParty(), gameState.getCurrentRoom().getRoom("east"), true);
                }
                return newGameState;
            }
        });

        commands.put("west", new Command() {

            @Override
            public GameState execute(GameState gameState, CommandPrinter commandPrinter, String commandString) {
                GameState newGameState = gameState;
                if (gameState.getCurrentRoom().getRoom("west") == null) {
                    commandPrinter.printMessage("You can’t go that way.");
                } else {
                    newGameState = new GameState(gameState.getParty(), gameState.getCurrentRoom().getRoom("west"), true);
                }
                return newGameState;
            }
        });

        return commands;
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
        if(VALID_COMMANDS.contains(commandString)) {
            return commands.get(commandString);
        }
        return new Command() {

            @Override
            public GameState execute(GameState gameState, CommandPrinter commandPrinter, String commandString) {
                commandPrinter.printMessage("Command not found");
                return gameState;
            }
        };
    }

    static class InvalidCommand {
        static double calculateSalesTax(double productCost) {
            return productCost * 0.0725;
        }
    }


        /**
     * Get the map of {@link Command}s.
     * @return The map of commands keyed by command string.
     */
    public static Map<String, Command> getCommands() {
        return commands;
    }
}