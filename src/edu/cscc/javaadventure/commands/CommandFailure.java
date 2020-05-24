package edu.cscc.javaadventure.commands;

/**
 * Functional interface for printing a command failure message.
 */
public interface CommandFailure {

    /**
     * Print the failure message.
     * @param message The message to be printed.
     */
    void printMessage(String message);
}
