package sbu.cs;

public abstract class Player implements GameObject {
    protected String playerName;
    final protected String type;
    protected int health;
    protected int maxHealth;
    protected int attackPower;
    protected boolean isAlive = true;
    public static final String WHITE = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    public Player(String playerName, String type, int health, int attackPower) {
        this.playerName = playerName;
        this.type = type;
        this.health = health;
        maxHealth = health;
        this.attackPower = attackPower;
    }

    @Override
    public void attack(GameObject target) {
        target.takeDamage(attackPower);
    }

    @Override
    public void takeDamage(int damage) {
        if (this.isAlive) {
            this.health -= damage;
            System.out.println(RED + "| player " + this.playerName + " got hit by " + damage + WHITE);
            System.out.println(GREEN + "| player " + this.playerName + "'s health is " + this.health + WHITE);
            if (health <= 0) {
                die();
            }
        }
    }

    @Override
    public void die() {
        isAlive = false;

        System.out.println(RED + "| player " + this.playerName + " died" + WHITE);
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
}
