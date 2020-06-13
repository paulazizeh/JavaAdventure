package edu.cscc.javaadventure.engine;

/**
 * Exception thrown when a roll is outside of the acceptable bounds.
 */
public class InvalidRollException extends Exception {
    public InvalidRollException(String message) {
        super(message);
    }
}
