package sbu.cs.monsterClasses;

import sbu.cs.Monster;
import sbu.cs.Player;

import java.util.List;

public class Dragon extends Monster {
    private final int fireDamage;
    private int hitCount = 0;
    private boolean isRaged = false;

    public Dragon(int health, int attackPower, int fireDamage) {
        super("DRAGON", health, attackPower);
        this.fireDamage = fireDamage;
        System.out.println("| DRAGON is now spawned");
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        // dragon goes on rage mode if got hit 3 times
        hitCount += 1;
        if (hitCount >= 3) {
            isRaged = true;
            System.out.println("| DRAGON on rage mode");
        }
    }

    public void fireAttack(List<Player> players) {
        // attack all players at once
        for (Player p : players) {
            p.takeDamage(fireDamage);
        }
        System.out.println("| DRAGON threw fire");
        System.out.println("| every player hit by DRAGON's fire attack");
    }

    public boolean isRaged() {
        return isRaged;
    }
}
