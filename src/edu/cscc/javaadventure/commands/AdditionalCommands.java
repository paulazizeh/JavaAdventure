package edu.cscc.javaadventure.commands;

import edu.cscc.javaadventure.JAObject;
import edu.cscc.javaadventure.Party;
import edu.cscc.javaadventure.Roller;
import edu.cscc.javaadventure.engine.GameState;
import edu.cscc.javaadventure.engine.InvalidRollException;
import edu.cscc.javaadventure.engine.combat.CharacterCombatant;
import edu.cscc.javaadventure.engine.combat.Combatant;
import edu.cscc.javaadventure.engine.combat.OpponentIncapacitatedException;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdditionalCommands {

    public static final String TAKE = "take";
    private static final String ATTACK = "attack";

    public static void addCommands() {
        addTakeCommand();
        addAttackCommand(Commands.getCommands());
    }

    private static void addTakeCommand() {
        Commands.VALID_COMMANDS.add(TAKE);
        Commands.getCommands().put(TAKE,
        (gameState, commandPrinter, commandString) -> {
            String argument = getCommandArgument(TAKE, commandString);
            Optional<String> maybeFound = findObjectInCurrentRoom(gameState, argument);
            Party currentParty = gameState.getParty();
            maybeFound.ifPresent(name -> {
                JAObject foundObject = getObjectByName(gameState, name);
                gameState.getParty().memberTake(currentParty.getMembers().get(0).getName(), foundObject);
                gameState.getCurrentRoom().removeFromContents(name);
            });
            return gameState;
        });
    }

    private static JAObject getObjectByName(GameState gameState, String name) {
        return gameState.getCurrentRoom().getObject(name);
    }

    private static Optional<String> findObjectInCurrentRoom(GameState gameState, String argument) {
        return gameState
                        .getCurrentRoom()
                        .listContents()
                        .stream()
                        .filter(name -> name.equals(argument))
                        .findFirst();
    }

    private static String getCommandArgument(String command, String commandString) {
        return commandString.replace(command, "").trim();
    }

    private static void addAttackCommand(Map<String, Command> commands) {
        Commands.VALID_COMMANDS.add(ATTACK);
        commands.put(ATTACK, ((gameState, commandFailure, commandString) -> {
            String argument = getCommandArgument(ATTACK, commandString);
            findObjectInCurrentRoom(gameState, argument).ifPresent(name -> {
                initiateCombat(gameState, name);
            });
            return gameState;
        }));
    }

    private static void initiateCombat(GameState gameState, String name) {
        try {
            Combatant combatant = (Combatant) getObjectByName(gameState, name);
            List<CharacterCombatant> characterCombatants = gameState.getParty().getMembers().stream().map(CharacterCombatant::new).collect(Collectors.toList());
            characterCombatants.forEach(characterCombatant -> {
                attackCombatant(gameState, combatant, characterCombatant);
            });

            if (combatant.isActiveCombatant()) {
                String attackString = attackRandomPartyMember(combatant, characterCombatants);
                System.out.println(attackString);
            }
        } catch (ClassCastException exception) {
            System.out.println("You can't fight that!");
        } catch (InvalidRollException e) {
            e.printStackTrace();
        } catch (OpponentIncapacitatedException e) {
            System.out.println("Their opponent is already incapacitated!");
        }
    }

    private static void attackCombatant(GameState gameState, Combatant combatant, CharacterCombatant characterCombatant) {
        try {
            if (combatant.isActiveCombatant()) {
                String attackDescription = characterCombatant.attack(Roller.roll(20), combatant);
                System.out.println(attackDescription);
                if (!combatant.isActiveCombatant()) {
                    System.out.println(combatant.getName() + " was defeated!");
                    gameState.getCurrentRoom().removeFromContents(combatant.getName());
                }
            }
        } catch (OpponentIncapacitatedException e) {
            System.out.println(combatant.getName() + " is already dead.");
        } catch (InvalidRollException e) {
            e.printStackTrace();
        }
    }

    private static String attackRandomPartyMember(Combatant combatant, List<CharacterCombatant> characterCombatants) throws OpponentIncapacitatedException, InvalidRollException {
        return combatant.attack(Roller.roll(20), characterCombatants.get(Roller.roll(characterCombatants.size() - 1)));
    }

}
