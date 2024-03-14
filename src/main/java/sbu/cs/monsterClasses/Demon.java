package sbu.cs.monsterClasses;

import sbu.cs.Monster;
import sbu.cs.Player;

import java.util.ArrayList;

public class Demon extends Monster {
    private final double soulEating;
    private int hitCount = 0;
    private boolean isRaged = false;
    public Demon(int health, int attackPower, double soulEating) {
        super(health, attackPower);
        this.soulEating = soulEating;
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        System.out.println("| DEMON hit by " + damage);

        hitCount += 1;
        if (hitCount >= 3) {
            isRaged = true;
            System.out.println("| DEMON in rage mode");
        }
    }

    @Override
    public void die() {
        super.die();
        System.out.println("| DEMON died");
    }

    public void eatSoul(ArrayList<Player> players) {
        for (Player p: players) {
            // reduce health and power of enemies
            p.setMaxHealth((int) (p.getMaxHealth() * (1 - soulEating)));
            isRaged = false;
        }

        System.out.println("| every player's maximum health is decreased by " + soulEating * 100 + "%");
    }

    public boolean getRaged() {
        return isRaged;
    }
}
