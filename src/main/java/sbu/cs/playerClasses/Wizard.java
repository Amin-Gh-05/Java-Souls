package sbu.cs.playerClasses;

import sbu.cs.GameObject;
import sbu.cs.Player;

public class Wizard extends Player {
    private int mana;
    private final int maxMana;
    private final int healSpellPower;
    private final int healSpellCost;
    private final int damageSpellPower;
    private final int damageSpellCost;

    public Wizard(String playerName, int health, int attackPower, int mana, int healSpellPower, int healSpellCost, int damageSpellPower, int damageSpellCost) {
        super(playerName, "WIZARD", health, attackPower);
        this.mana = mana;
        maxMana = mana;
        this.healSpellPower = healSpellPower;
        this.healSpellCost = healSpellCost;
        this.damageSpellPower = damageSpellPower;
        this.damageSpellCost = damageSpellCost;
        System.out.println(GREEN + "| WIZARD " + this.playerName + " is now spawned" + WHITE);
    }

    public void castHealSpell() {
        if (healSpellCost <= mana) {
            if (health + healSpellPower > maxHealth) {
                health = maxHealth;
            } else {
                health += healSpellPower;
            }

            mana -= healSpellCost;
            System.out.println(GREEN + "| WIZARD " + this.playerName + " cast a healing spell");
            System.out.println("| WIZARD " + this.playerName + " healed himself by " + this.healSpellPower + WHITE);
        } else {
            System.out.println(RED + "| WIZARD " + this.playerName + "'s mana is not enough" + WHITE);
        }
    }

    public void castDamageSpell(GameObject target) {
        if (damageSpellCost <= mana) {
            target.takeDamage(damageSpellPower);
            mana -= damageSpellCost;
            System.out.println(GREEN + "| WIZARD " + this.playerName + " cast a damage spell");
            System.out.println("| WIZARD " + this.playerName + " hit enemy by " + this.damageSpellPower + WHITE);
        }
    }

    public void increaseMana(int percent) {
        mana += mana * percent / 100;
        if (mana > maxMana) {
            mana = maxMana;
        }
        System.out.println(GREEN + "| WIZARD " + this.playerName + "'s mana is " + mana + WHITE);
    }
}
