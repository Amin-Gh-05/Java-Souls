package sbu.cs.monsterClasses;

import sbu.cs.Monster;
import sbu.cs.Player;

import java.util.ArrayList;

public class Dragon extends Monster {
    private final int fireDamage;
    private int hitCount = 0;
    private boolean isRaged = false;
    public Dragon(int health, int attackPower, int fireDamage) {
        super(health, attackPower);
        this.fireDamage = fireDamage;
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        System.out.println("| DRAGON hit by " + damage);

        hitCount += 1;
        if (hitCount >= 3) {
            isRaged = true;
            System.out.println("| DRAGON in rage mode");
        }
    }

    @Override
    public void die() {
        super.die();
        System.out.println("| DRAGON died");
    }

    public void fireAttack(ArrayList<Player> players) {
        // attack all players at once
        for (Player p: players) {
            p.takeDamage(fireDamage);
        }

        System.out.println("| every player hit by DRAGON's Fire-Attack");
    }

    public boolean getRaged() {
        return isRaged;
    }
}
