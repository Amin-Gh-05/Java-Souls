package sbu.cs;

public abstract class Monster implements GameObject {
    protected final String type;
    protected int health;
    protected int maxHealth;
    protected int attackPower;
    protected boolean isAlive = true;
    public static final String WHITE = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    public Monster(String type, int health, int attackPower) {
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
            health -= damage;
            System.out.println(GREEN + "| " + this.type + " got hit by " + damage + WHITE);
            System.out.println(RED + "| " + this.type + "'s health is " + this.health + WHITE);
            if (health <= 0) {
                die();
            }
        }
    }

    @Override
    public void die() {
        isAlive = false;
        System.out.println(GREEN + "| " + this.type + " died" + WHITE);
    }
}
