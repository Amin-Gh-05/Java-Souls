package sbu.cs.monsterClasses;

import sbu.cs.GameObject;
import sbu.cs.Monster;
import sbu.cs.Player;

import java.util.ArrayList;

public class Dragon extends Monster {
    private final int fireDamage;
    public Dragon(int health, int attackPower, int fireDamage) {
        super(health, attackPower);
        this.fireDamage = fireDamage;
    }

    public void fireAttack(ArrayList<Player> players) {
        for (Player p: players) {
            p.takeDamage(fireDamage);
        }
    }
}

