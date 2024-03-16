package sbu.cs.playerClasses;

import sbu.cs.GameObject;
import sbu.cs.Player;

public class Assassin extends Player {
    private boolean isInvisible = false;
    private final int criticalMultiplier;

    public Assassin(String playerName, int health, int attackPower, int criticalMultiplier) {
        super(playerName, "ASSASSIN", health, attackPower);
        this.criticalMultiplier = criticalMultiplier;
    }

    @Override
    public void attack(GameObject target) {
        if (isInvisible) {
            // multiplies damage when assassin's invisible
            System.out.println("| ASSASSIN " + this.playerName + " attacked the enemy by critical hit");
            target.takeDamage(attackPower * criticalMultiplier);
            isInvisible = false;
        } else {
            target.takeDamage(attackPower);
        }
    }

    public void setInvisible(boolean isInvisible) {
        this.isInvisible = isInvisible;
    }
}
