package sbu.cs.monsterClasses;

import sbu.cs.Monster;

public class Goblin extends Monster {
    public Goblin(int health, int attackPower) {
        super(health, attackPower);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        System.out.println("| GOBLIN hit by " + damage);
    }

    @Override
    public void die() {
        super.die();
        System.out.println("| GOBLIN died");
    }
}
