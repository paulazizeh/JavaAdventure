package edu.cscc.javaadventure;

public enum Direction {
    NORTH("NORTH", "n"),
    SOUTH("SOUTH", "s"),
    EAST("EAST", "e"),
    WEST("WEST", "w"),
    UP("UP", "u"),
    DOWN("DOWN", "d");

    private final String direction;
    private final String abbreviation;


    Direction(String direction, String abbreviation) {
        this.direction = direction;
        this.abbreviation = abbreviation;
    }

    public String getDirection() { return direction; }

    public String getAbbreviation() { return abbreviation; }

    public static Direction getOppositeDirection(Direction direction) {
        switch (direction) {
            case NORTH:
                return SOUTH;
            case SOUTH:
                return NORTH;
            case EAST:
                return WEST;
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            default:
                return EAST;

        }

    }
}
