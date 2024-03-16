package sbu.cs.monsterClasses;

import sbu.cs.Monster;

public class Skeleton extends Monster {
    private int deathCount = 0;

    public Skeleton(int health, int attackPower) {
        super("SKELETON", health, attackPower);
        System.out.println("| SKELETON is now spawned");
    }

    @Override
    public void die() {
        if (deathCount > 0) {
            die();
            System.out.println("| SKELETON died");
        } else {
            // skeleton can be vitalized one
            health = maxHealth;
            deathCount += 1;
            System.out.println("| SKELETON is vitalized again");
        }
    }
}
