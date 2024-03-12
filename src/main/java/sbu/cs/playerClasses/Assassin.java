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
        } else {
            target.takeDamage(attackPower);
        }
    }
}
