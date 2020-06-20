package edu.cscc.javaadventure.commands;

/**
 * Functional interface for printing a command message.
 */
public interface CommandPrinter {

    /**
     * Print the command message.
     * @param message The message to be printed.
     */
    void printMessage(String message);
}
