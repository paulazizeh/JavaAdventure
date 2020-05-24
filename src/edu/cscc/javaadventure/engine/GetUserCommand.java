package edu.cscc.javaadventure.engine;

/**
 * Functional interface to retrieve user input.
 */
public interface GetUserCommand {

    /**
     * Retrieve the user input in String format.
     * @return Input from the user.
     */
    String getCommand();
}
