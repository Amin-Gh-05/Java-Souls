package sbu.cs.playerClasses;

import sbu.cs.GameObject;
import sbu.cs.Player;

// Implementing this class is optional
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
        this.healSpellPower = healSpellPower;
        this.healSpellCost = healSpellCost;
        this.damageSpellPower = damageSpellPower;
        this.damageSpellCost = damageSpellCost;
        maxMana = mana;
    }

    public void castHealSpell() {
        if (healSpellCost <= mana) {
            if (health + healSpellPower > maxHealth) {
                health = maxHealth;
            } else {
                health += healSpellPower;
            }
            mana -= healSpellCost;
        }
    }

    public void castDamageSpell(GameObject target) {
        if (damageSpellCost <= mana) {
            target.takeDamage(damageSpellPower);
            mana -= damageSpellCost;
        }
    }
}
