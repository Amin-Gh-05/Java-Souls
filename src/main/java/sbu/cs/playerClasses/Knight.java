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
            isBlocking = false;
        }

        if (damage > armor) {
            health -= damage - armor;
            armor = 0;
            System.out.println("| KNIGHT " + this.playerName + " hit by " + damage);
        } else {
            armor -= damage;
            System.out.println("| KNIGHT " + this.playerName + "'s armor is down by " + damage);
        }
    }

    public void setBlocking(boolean isBlocking) {
        this.isBlocking = isBlocking;
        if (isBlocking) {
            System.out.println("KNIGHT " + this.playerName + " is blocking");
        } else {
            System.out.println("KNIGHT " + this.playerName + " put down the guard");
        }
    }
}
