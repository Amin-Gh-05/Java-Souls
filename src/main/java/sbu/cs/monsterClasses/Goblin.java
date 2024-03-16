package sbu.cs.monsterClasses;

import sbu.cs.Monster;

public class Goblin extends Monster {
    public Goblin(int health, int attackPower) {
        super("GOBLIN", health, attackPower);
        System.out.println("| GOBLIN is now spawned");
    }
}
