package sbu.cs.playerClasses;

import sbu.cs.Player;

public class Knight extends Player {
    private int armor;
    private boolean isBlocking = false;
    public Knight(String playerName, int health, int attackPower, int armor) {
        super(playerName, health, attackPower);
        this.armor = armor;
    }

    @Override
    public void takeDamage(int damage) {
        if (isBlocking) {
            damage /= 2;
        }

        if (damage > armor) {
            health -= damage - armor;
            armor = 0;
        } else {
            armor -= damage;
        }
    }

    public void block() {
        isBlocking = true;
    }
}
