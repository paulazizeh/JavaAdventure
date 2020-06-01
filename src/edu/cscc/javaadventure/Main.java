package edu.cscc.javaadventure;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("The adventure begins!");

        Character wizard = new Character("Gandalf");
        Character fighter = new Character("Gimli");
        Character ringBearer = new Character("Frodo");
        Party party = new Party();

        Scanner scanner = new Scanner(System.in);
        boolean done = false;
        do {
            System.out.println("Choose your party members.");
            System.out.println("Who would you like to add?");
            System.out.println("1. " + wizard.getName());
            System.out.println("2. " + fighter.getName());
            System.out.println("3. " + ringBearer.getName());
            System.out.println("4. Done");
            System.out.print(" (Choices are 1, 2, 3, 4): ");
            String choice = scanner.nextLine();
            switch(choice) {
                case "1":
                    party.addMember(wizard);
                    break;
                case "2":
                    party.addMember(fighter);
                    break;
                case "3":
                    party.addMember(ringBearer);
                    break;
                case "4":
                    done = true;
                    break;
                default:
                    done = true;
                    party.addMember(wizard);
                    party.addMember(fighter);
                    party.addMember(ringBearer);
            }
        } while(!done);

        System.out.println("Party size: " + party.size());
        for (Character member: party) {
            System.out.println(member.getName());
        }

        TreasureChest treasureChest = new TreasureChest();
        try {
            treasureChest.open();
            treasureChest.lock();
        } catch (ChestLockedException e) {
            System.out.println("Oops, the chest is already locked.");
        } catch (ChestAlreadyOpenException e) {
            System.out.println("Oops, the chest is already open.");
        }
    }
}
