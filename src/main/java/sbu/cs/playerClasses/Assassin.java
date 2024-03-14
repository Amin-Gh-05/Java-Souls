package sbu.cs.playerClasses;

import sbu.cs.GameObject;
import sbu.cs.Player;

public class Assassin extends Player {
    private boolean isInvisible = false;
    private final int criticalMultiplier;
    public Assassin(String playerName, int health, int attackPower, int criticalMultiplier) {
        super(playerName, health, attackPower);
        this.criticalMultiplier = criticalMultiplier;
    }

    @Override
    public void attack(GameObject target) {
        if (isInvisible) {
            target.takeDamage(attackPower * criticalMultiplier);
            isInvisible = false;
            System.out.println("| ASSASSIN " + this.playerName + " attacked the enemy by Critical-Hit");
        } else {
            target.takeDamage(attackPower);
        }
    }

    public void setInvisible(boolean isInvisible) {
        this.isInvisible = isInvisible;
        if (isInvisible) {
            System.out.println("ASSASSIN " + this.playerName + " is gone invisible");
        } else {
            System.out.println("ASSASSIN " + this.playerName + " is gone visible");
        }
    }
}
