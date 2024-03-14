package sbu.cs.monsterClasses;

import sbu.cs.Monster;

public class Skeleton extends Monster {
    private int deathCount = 0;
    public Skeleton(int health, int attackPower) {
        super(health, attackPower);
    }

    @Override
    public void die() {
        if (deathCount > 0) {
            die();
            System.out.println("| SKELETON died");
        } else {
            health = maxHealth;
            deathCount += 1;
            System.out.println("| SKELETON is vitalized again");
        }
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        System.out.println("| SKELETON hit by " + damage);
    }
}
