package edu.cscc.javaadventure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TreasureChestTest {

    @Test
    public void itThrowsAnExceptionWhenTheChestIsAlreadyOpenOrLocked() throws ChestAlreadyOpenException,
            ChestLockedException {
        TreasureChest treasureChest = new TreasureChest();

        assertThrows(ChestLockedException.class, () -> {
            treasureChest.open();
        });

        treasureChest.unlock();
        treasureChest.open();

        assertThrows(ChestAlreadyOpenException.class, () -> {
            treasureChest.open();
        });
    }
}