package sbu.cs;

import sbu.cs.playerClasses.*;
import sbu.cs.monsterClasses.*;

import java.util.*;

import static java.lang.Thread.sleep;

public class App {
    // two lists to store players and monsters in the game
    private static final List<Monster> monsterList = new ArrayList<>();
    private static final List<Goblin> goblinList = new ArrayList<>();
    private static final List<Skeleton> skeletonList = new ArrayList<>();
    private static final List<Dragon> dragonList = new ArrayList<>();
    private static final List<Demon> demonList = new ArrayList<>();
    private static final List<Player> playerList = new ArrayList<>();
    private static final List<Assassin> assassinList = new ArrayList<>();
    private static final List<Knight> knightList = new ArrayList<>();
    private static final List<Wizard> wizardList = new ArrayList<>();
    private static final List<Vegabond> vegabondList = new ArrayList<>();
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print("""
                   ####     ##     ##  ##     ##               ####     ####    ##  ##   ##        ####  \s
                    ##     ####    ##  ##    ####             ##  ##   ##  ##   ##  ##   ##       ##  ## \s
                    ##    ##  ##   ##  ##   ##  ##            ##       ##  ##   ##  ##   ##       ##     \s
                    ##    ######   ##  ##   ######             ####    ##  ##   ##  ##   ##        ####  \s
                    ##    ##  ##   ##  ##   ##  ##                ##   ##  ##   ##  ##   ##           ## \s
                 ## ##    ##  ##     ###    ##  ##            ##  ##   ##  ##   ##  ##   ##       ##  ## \s
                  ###     ##  ##     ##     ##  ##             ####     ####     ####    ######    ####  \s
                                                                                                         \s
                """);
        createCharacter();
        createCharacter();
        for (int i = 0; i < 3; i++) {
            int dice = rollDice();
            if (dice == 1) {
                spawnMonster("DEMON");
            } else if (dice == 2) {
                spawnMonster("DRAGON");
            } else if (dice == 3 || dice == 4) {
                spawnMonster("SKELETON");
            } else if (dice == 5 || dice == 6) {
                spawnMonster("GOBLIN");
            }
        }
        startBattle();
    }

    public static void createCharacter() {
        // scanner to get input from user
        System.out.print("? choose your class (ASSASSIN, KNIGHT, WIZARD, VEGABOND): ");
        String charClass = read.nextLine();
        // create character based on the class and add it to playerList
        switch (charClass) {
            case "ASSASSIN" -> {
                System.out.print("? enter your character's name (with no space): ");
                String name = read.nextLine();
                Assassin player = new Assassin(name, 100, 12, 3);
                playerList.add(player);
                assassinList.add(player);
            }
            case "KNIGHT" -> {
                System.out.print("? enter your character's name (with no space): ");
                String name = read.nextLine();
                Knight player = new Knight(name, 120, 10, 30);
                playerList.add(player);
                knightList.add(player);
            }
            case "WIZARD" -> {
                System.out.print("? enter your character's name (with no space): ");
                String name = read.nextLine();
                Wizard player = new Wizard(name, 80, 8, 50, 30, 30, 25, 40);
                playerList.add(player);
                wizardList.add(player);
            }
            case "VEGABOND" -> {
                System.out.print("? enter your character's name (with no space): ");
                String name = read.nextLine();
                Vegabond player = new Vegabond(name, 100, 10, 60, 15, 40, 25);
                playerList.add(player);
                vegabondList.add(player);
            }
            default -> System.out.println("| please enter a valid choice!");
        }
    }

    public static void spawnMonster(String name) {
        // spawn a monster based on the type
        switch (name) {
            case "GOBLIN" -> {
                Goblin monster = new Goblin(40, 15);
                monsterList.add(monster);
                goblinList.add(monster);
            }
            case "DRAGON" -> {
                Dragon monster = new Dragon(150, 20, 45);
                monsterList.add(monster);
                dragonList.add(monster);
            }
            case "SKELETON" -> {
                Skeleton monster = new Skeleton(30, 10);
                monsterList.add(monster);
                skeletonList.add(monster);
            }
            case "DEMON" -> {
                Demon monster = new Demon(120, 20, 0.1);
                monsterList.add(monster);
                demonList.add(monster);
            }
        }
    }

    public static int rollDice() {
        // random number generation
        Random dice = new Random();
        int result = dice.nextInt(6);
        // sync numbers with real dice
        result += 1;

        switch (result) {
            case 1 -> System.out.print("""
                    -----
                    |   |
                    | o |
                    |   |
                    -----
                    """);
            case 2 -> System.out.print("""
                    -----
                    |o  |
                    |   |
                    |  o|
                    -----
                    """);
            case 3 -> System.out.print("""
                    -----
                    |o  |
                    | o |
                    |  o|
                    -----
                    """);
            case 4 -> System.out.print("""
                    -----
                    |o o|
                    |   |
                    |o o|
                    -----
                    """);
            case 5 -> System.out.print("""
                    -----
                    |o o|
                    | o |
                    |o o|
                    -----
                    """);
            case 6 -> System.out.print("""
                    -----
                    |o o|
                    |o o|
                    |o o|
                    -----
                    """);
        }

        return result;
    }

    public static void startBattle() {
        int round = 1;

        while (true) {
            // checks if there is any monster left
            if (monsterList.isEmpty()) {
                System.out.println("""
                        ##  ##    ## ##   ##  ###           ##   ##   ## ##   ###  ## \s
                        ##  ##   ##   ##  ##   ##           ##   ##  ##   ##    ## ## \s
                        ##  ##   ##   ##  ##   ##           ##   ##  ##   ##   # ## # \s
                         ## ##   ##   ##  ##   ##           ## # ##  ##   ##   ## ##  \s
                          ##     ##   ##  ##   ##           # ### #  ##   ##   ##  ## \s
                          ##     ##   ##  ##   ##            ## ##   ##   ##   ##  ## \s
                          ##      ## ##    ## ##            ##   ##   ## ##   ###  ## \s
                                                                                      \s
                        """);
                break;
            }
            // checks if there is any player left
            if (playerList.isEmpty()) {
                System.out.println("""
                         ## ##     ##     ##   ##  ### ###            ## ##   ### ###  ### ###  ### ##  \s
                        ##   ##     ##     ## ##    ##  ##           ##   ##   ##  ##   ##  ##   ##  ## \s
                        ##        ## ##   # ### #   ##               ##   ##   ##  ##   ##       ##  ## \s
                        ##  ###   ##  ##  ## # ##   ## ##            ##   ##   ##  ##   ## ##    ## ##  \s
                        ##   ##   ## ###  ##   ##   ##               ##   ##   ### ##   ##       ## ##  \s
                        ##   ##   ##  ##  ##   ##   ##  ##           ##   ##    ###     ##  ##   ##  ## \s
                         ## ##   ###  ##  ##   ##  ### ###            ## ##      ##    ### ###  #### ## \s
                                                                                                        \s
                        """);
                break;
            }

            System.out.println("| round: " + round);
            int dice = rollDice();

            // add player every 3 round
            if (round % 3 == 0) {
                createCharacter();
            }
            // add monster every 2 round
            if (round % 2 == 0) {
                if (dice == 1) {
                    spawnMonster("DEMON");
                } else if (dice == 2) {
                    spawnMonster("DRAGON");
                } else if (dice == 3 || dice == 4) {
                    spawnMonster("SKELETON");
                } else if (dice == 5 || dice == 6) {
                    spawnMonster("GOBLIN");
                }
            }

            // print players alive
            System.out.print("| you have " + playerList.size() + " players: ");
            for (Player p : playerList) {
                System.out.print(p.playerName + "(" + p.type + ") ");
            }
            System.out.print("\n");
            // print monsters alive
            System.out.print("| there are " + monsterList.size() + " monsters: ");
            System.out.print(goblinList.size() + " GOBLINS ");
            System.out.print(skeletonList.size() + " SKELETONS ");
            System.out.print(dragonList.size() + " DRAGONS ");
            System.out.print(demonList.size() + " DEMONS ");
            System.out.print("\n");

            // set assassins invisibility
            if (!(assassinList.isEmpty())) {
                if (dice == 5 || dice == 6) {
                    for (Assassin a : assassinList) {
                        a.setInvisible(true);
                    }
                } else if (dice == 1 || dice == 2) {
                    for (Assassin a : assassinList) {
                        a.setInvisible(false);
                    }
                }
            }
            // set knights guard
            if (!(knightList.isEmpty())) {
                if (dice == 5 || dice == 6) {
                    for (Knight k : knightList) {
                        k.setBlocking(true);
                    }
                } else if (dice == 1 || dice == 2) {
                    for (Knight k : knightList) {
                        k.setBlocking(false);
                    }
                }
            }
            // set wizard spell-casting and mana
            if (!(wizardList.isEmpty())) {
                if (dice == 5 || dice == 6) {
                    for (Wizard w : wizardList) {
                        w.increaseMana(40);
                    }
                } else if (dice == 3 || dice == 4) {
                    for (Wizard w : wizardList) {
                        w.increaseMana(30);
                    }
                } else if (dice == 1 || dice == 2) {
                    for (Wizard w : wizardList) {
                        w.increaseMana(20);
                    }
                }

                Random spell = new Random();
                for (Wizard w : wizardList) {
                    int cast = spell.nextInt(3);
                    switch (cast) {
                        case 1 -> w.castHealSpell(playerList);
                        case 2 -> {
                            Random target = new Random();
                            w.castDamageSpell(monsterList.get(target.nextInt(monsterList.size())));
                        }
                    }
                }
            }
            // set vegabond dodging and heavy attacks
            if (!(vegabondList.isEmpty())) {
                for (Vegabond v: vegabondList) {
                    v.setDodging(false);
                }
                if (dice == 5 || dice == 6) {
                    for (Vegabond v: vegabondList) {
                        v.increaseStamina(40);
                        v.dodge();
                    }
                } else if (dice == 3 || dice == 4) {
                    for (Vegabond v: vegabondList) {
                        v.increaseStamina(30);
                    }
                } else if (dice == 1 || dice == 2) {
                    for (Vegabond v: vegabondList) {
                        v.increaseStamina(20);
                    }
                }

                Random choice = new Random();
                for (Vegabond v: vegabondList) {
                    int attack = choice.nextInt(3);
                    if (attack == 2) {
                        v.heavyAttack(monsterList);
                    }
                }
            }
            // get player's input for attack
            System.out.print("? make your move: ");
            String input = read.nextLine();
            String[] words = input.split(" ");
            String name = words[0];
            String target = words[1];
            for (Player p : playerList) {
                if (Objects.equals(p.playerName, name)) {
                    for (Monster m : monsterList) {
                        if (Objects.equals(m.type, target)) {
                            p.attack(m);
                        }
                    }
                }
            }

            // demon rage attack
            for (Demon d : demonList) {
                if (d.isRaged()) {
                    d.eatSoul(playerList);
                }
            }
            // dragon rage attack
            for (Dragon d : dragonList) {
                if (d.isRaged()) {
                    d.fireAttack(playerList);
                }
            }
            // two of monsters attack randomly
            Random monster = new Random();
            Random player = new Random();
            monsterList.get(monster.nextInt(monsterList.size())).attack(playerList.get(player.nextInt(playerList.size())));
            monsterList.get(monster.nextInt(monsterList.size())).attack(playerList.get(player.nextInt(playerList.size())));

            // check if any monster or player is dead and remove them from lists
            monsterList.removeIf(m -> !(m.isAlive));
            goblinList.removeIf(m -> !(m.isAlive));
            dragonList.removeIf(m -> !(m.isAlive));
            skeletonList.removeIf(m -> !(m.isAlive));
            demonList.removeIf(m -> !(m.isAlive));
            playerList.removeIf(p -> !(p.isAlive));
            assassinList.removeIf(p -> !(p.isAlive));
            knightList.removeIf(p -> !(p.isAlive));
            wizardList.removeIf(p -> !(p.isAlive));
            vegabondList.removeIf(p -> !(p.isAlive));

            System.out.println("| going for the next round...");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            round += 1;
            System.out.println("----------------------------------------\n");
        }

        System.out.print("? press enter to exit...");
        read.nextLine();
        read.close();
    }
}
