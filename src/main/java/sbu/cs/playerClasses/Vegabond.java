package sbu.cs.playerClasses;

import sbu.cs.Monster;
import sbu.cs.Player;

import java.util.List;

public class Vegabond extends Player {
    private int stamina;
    private final int maxStamina;
    private final int heavyAttackPower;
    private final int heavyAttackStaminaCost;
    private final int dodgeStaminaCost;
    private boolean isDodging = false;

    public Vegabond(String playerName, int health, int attackPower, int stamina, int heavyAttackPower, int heavyAttackStaminaCost, int dodgeStaminaCost) {
        super(playerName, "VEGABOND", health, attackPower);
        this.stamina = stamina;
        maxStamina = stamina;
        this.heavyAttackPower = heavyAttackPower;
        this.heavyAttackStaminaCost = heavyAttackStaminaCost;
        this.dodgeStaminaCost = dodgeStaminaCost;
    }

    @Override
    public void takeDamage(int damage) {
        if (isAlive) {
            if (isDodging) {
                System.out.println(GREEN + "| VEGABOND " + this.playerName + " dodged the enemy attack" + WHITE);
            } else {
                this.health -= damage;
                System.out.println(RED + "| VEGABOND " + this.playerName + " hit by " + damage + WHITE);
                System.out.println(GREEN + "| VEGABOND " + this.playerName + "'s health is " + this.health + WHITE);
            }

            if (health <= 0) {
                die();
            }
        }
    }

    public void setDodging(boolean dodging) {
        isDodging = dodging;
    }

    public void heavyAttack(List<Monster> monsters) {
        if (heavyAttackStaminaCost <= stamina) {
            // hit every monster using stamina
            for (Monster m: monsters) {
                if (m.isAlive()) {
                    m.takeDamage(heavyAttackPower);
                }
            }
            this.stamina -= heavyAttackStaminaCost;
            System.out.println(GREEN + "| VEGABOND " + this.playerName + " used heavy attack");
            System.out.println("| VEGABOND " + this.playerName + " hit every monster by " + this.heavyAttackPower + WHITE);
        } else {
            System.out.println(RED + "| VEGABOND " + this.playerName + "'s stamina is not enough" + WHITE);
        }
    }

    public void dodge() {
        if (dodgeStaminaCost <= stamina) {
            isDodging = true;
            this.stamina -= dodgeStaminaCost;
        }
    }

    public void increaseStamina(int percent) {
        stamina += stamina * percent / 100;
        if (stamina > maxStamina) {
            stamina = maxStamina;
        }

        System.out.println(GREEN + "| VEGABOND " + this.playerName + "'s stamina is " + stamina + WHITE);
    }
}
