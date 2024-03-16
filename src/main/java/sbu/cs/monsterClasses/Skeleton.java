package sbu.cs.monsterClasses;

import sbu.cs.Monster;

public class Skeleton extends Monster {
    private int deathCount = 0;

    public Skeleton(int health, int attackPower) {
        super("SKELETON", health, attackPower);
        System.out.println(RED + "| SKELETON is now spawned" + WHITE);
    }

    @Override
    public void die() {
        if (deathCount > 0) {
            die();
            System.out.println(GREEN + "| SKELETON died" + WHITE);
        } else {
            // skeleton can be vitalized one
            health = maxHealth;
            deathCount += 1;
            System.out.println(RED + "| SKELETON is vitalized again" + WHITE);
        }
    }
}
