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
            isAlive = false;
        } else {
            health = maxHealth;
            deathCount += 1;
        }
    }
}
