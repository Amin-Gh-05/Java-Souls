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
        super(playerName, health, attackPower);
        this.mana = mana;
        maxMana = mana;
        this.healSpellPower = healSpellPower;
        this.healSpellCost = healSpellCost;
        this.damageSpellPower = damageSpellPower;
        this.damageSpellCost = damageSpellCost;
    }

    public void castHealSpell() {
        if (healSpellCost <= mana) {
            if (health + healSpellPower > maxHealth) {
                health = maxHealth;
            } else {
                health += healSpellPower;
            }

            mana -= healSpellCost;
            System.out.println("| WIZARD " + this.playerName + " healed himself by " + this.healSpellPower);
        } else {
            System.out.println("| WIZARD " + this.playerName + "'s mana is not enough");
        }
    }

    public void castDamageSpell(GameObject target) {
        if (damageSpellCost <= mana) {
            target.takeDamage(damageSpellPower);
            mana -= damageSpellCost;
            System.out.println("| WIZARD " + this.playerName + "cast Damage-Spell");
        }
    }

    public void setMana(int mana) {
        this.mana = mana;
        System.out.println("| WIZARD " + this.playerName + "'s mana is " + mana);
    }
}
