package sbu.cs.monsterClasses;

import sbu.cs.Monster;
import sbu.cs.Player;

import java.util.List;

public class Demon extends Monster {
    private final double soulEating;
    private int hitCount = 0;
    private boolean isRaged = false;

    public Demon(int health, int attackPower, double soulEating) {
        super("DEMON", health, attackPower);
        this.soulEating = soulEating;
        System.out.println(RED + "| DEMON is now spawned" + WHITE);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        // demon goes on rage mode if got hit 3 times
        hitCount += 1;
        if (hitCount >= 3) {
            isRaged = true;
            System.out.println(RED + "| DEMON on rage mode" + WHITE);
        }
    }

    public void eatSoul(List<Player> players) {
        for (Player p : players) {
            // reduce health and power of enemies
            p.setMaxHealth((int) (p.getMaxHealth() * (1 - soulEating)));
        }
        System.out.println(RED + "| DEMON ate soul of players");
        System.out.println("| every player's maximum health is decreased by " + soulEating * 100 + "%" + WHITE);
        isRaged = false;
        hitCount = 0;
    }

    public boolean isRaged() {
        return isRaged;
    }
}
