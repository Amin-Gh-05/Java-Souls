package sbu.cs.playerClasses;

import sbu.cs.Player;

public class Knight extends Player {
    private int armor;
    private boolean isBlocking = false;

    public Knight(String playerName, int health, int attackPower, int armor) {
        super(playerName, "KNIGHT", health, attackPower);
        this.armor = armor;
        System.out.println(GREEN + "| KNIGHT " + this.playerName + " is now spawned" + WHITE);
    }

    @Override
    public void takeDamage(int damage) {
        if (isBlocking) {
            // reduces damage taken if knight's guard is up
            damage /= 2;
            isBlocking = false;
        }

        if (damage > armor) {
            health -= damage - armor;
            armor = 0;
            System.out.println(RED + "| KNIGHT " + this.playerName + " hit by " + damage + WHITE);
            System.out.println(GREEN + "| KNIGHT " + this.playerName + "'s health is " + this.health + WHITE);
        } else {
            armor -= damage;
            System.out.println(RED + "| KNIGHT " + this.playerName + "'s armor is down by " + damage + WHITE);
            System.out.println(GREEN + "| KNIGHT " + this.playerName + "'s armor left is " + this.armor + WHITE);
        }

        if (health <= 0) {
            die();
        }
    }

    public void setBlocking(boolean isBlocking) {
        this.isBlocking = isBlocking;
        if (isBlocking) {
            System.out.println(GREEN + "| KNIGHT " + this.playerName + "'s guard is up" + WHITE);
        } else {
            System.out.println(RED + "| KNIGHT " + this.playerName + "'s guard is down" + WHITE);
        }
    }
}
