package edu.cscc.javaadventure;

/**
 * Builds the game map by creating and connecting Room objects.
 * See the docs on Room for more detail.
 */
public interface GameMap {

    /**
     * Returns a fully built map composed of connected Room objects.
     * @return The starting point Room of the map.
     */
    static Room buildMap() {
        Room dungeonEntrance = new Room("Dungeon Entrance",
                "You're in the middle of some ancient ruins.\n" +
                        "There is a trapdoor with an iron ladder leading down into the darkness."
        );

        Room aDarkRoom = new Room("A dark room",
                "You are in a dark room with stone walls.\n" +
                        "There is a ladder leading up. You can smell fresh air coming from above.\n" +
                        "There is a door to the west leading into darkness..."
        );

        Room hallway = new Room("A hallway",
                "You are in a hallway full of spiderwebs.\n" +
                        "The walls are lined with the decaying remains of what was surely once beautiful tapestries depicting epic battles and a king on a golden throne.\n"
                        + "Time has erased the features of the king...\n" +
                        "The hallway is silent except for the sound of your breathing.\n" +
                        "There is an iron ladder leading down into the darkness. You can hear running water below.");

        Room grotto = new Room("The grotto",
                "You are in an underground grotto. There is a large pool of water lit by some kind of bioluminescence.\n" +
                        "The walls are made of rough stone.\n" +
                        "There is an iron ladder leading up." +
                        "The water is shallow, and you can see passages leading away to both the north and the south.");

        Room riversEdge = new Room("The river's edge",
                "You are at the edge of an underground river.\n" +
                        "You can't tell how deep the water is as it rushes past in a torrent.\n" + "This looks like a dead end.\n" +
                        "There is a soft glow coming from the passageway to the south."
        );

        Room caveNetworkEntrance = new Room("Entrance to the underground halls",
                "You find yourself in a large cavern which expands out deeply.\n" +
                        "Bioluminescence lights the cavern.\n" +
                        "Gazing out across the cavern you can dimly see great pillars and platforms forming a maze of a great hall.\n" +
                        "There is a small passageway with ankle-deep water to the north.");

        dungeonEntrance.connectRoom(Room.DOWN, aDarkRoom);
        aDarkRoom.connectRoom(Room.WEST, hallway);
        hallway.connectRoom(Room.DOWN, grotto);
        grotto.connectRoom(Room.NORTH, riversEdge);
        grotto.connectRoom(Room.SOUTH, caveNetworkEntrance);

        return dungeonEntrance;
    }
}
