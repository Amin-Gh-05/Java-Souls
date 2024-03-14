package sbu.cs;

import sbu.cs.playerClasses.*;
import sbu.cs.monsterClasses.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class App {
    // two lists to store players and monsters in the game
    private static List<Monster> monsterList = new ArrayList<>();
    private static List<Player> playerList = new ArrayList<>();


    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu() {
        createCharacter();
        startBattle();
    }

    public static void createCharacter() {
        // scanner to get input from user
        Scanner read = new Scanner(System.in);
        System.out.print("Choose your class (Assassin, Knight, Wizard): ");
        String charClass = read.nextLine();
        // create character based on the class and add it to playerList
        switch (charClass) {
            case "Assassin" -> {
                System.out.print("Enter your character's name: ");
                String name = read.nextLine();
                Assassin player = new Assassin(name, 100, 10, 3);
                playerList.add(player);
            }
            case "Knight" -> {
                System.out.print("Enter your character's name: ");
                String name = read.nextLine();
                Knight player = new Knight(name, 120, 10, 30);
                playerList.add(player);
            }
            case "Wizard" -> {
                System.out.print("Enter your character's name: ");
                String name = read.nextLine();
                Wizard player = new Wizard(name, 80, 8, 50, 30, 30, 25, 40);
                playerList.add(player);
            }
            default -> System.out.println("Please enter a valid choice!");
        }

        read.close();
    }

    public static void spawnMonster(String name) {
        // spawn a monster based on the type
        switch (name) {
            case "Goblin" -> {
                Goblin monster = new Goblin(50, 20);
                monsterList.add(monster);
            }
            case "Dragon" -> {
                Dragon monster = new Dragon(200, 15, 45);
                monsterList.add(monster);
            }
            case "Skeleton" -> {
                Skeleton monster = new Skeleton(40, 10);
                monsterList.add(monster);
            }
            case "Demon" -> {
                Demon monster = new Demon(180, 20, 0.1);
                monsterList.add(monster);
            }
        }
    }

    public static void startBattle() {
        Scanner read = new Scanner(System.in);
        int round = 1;

        while (true) {
            if (playerList.isEmpty()) {
                System.out.println("GAME OVER!");
                break;
            }
        }
    }
}