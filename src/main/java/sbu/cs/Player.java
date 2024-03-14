package sbu.cs;

public abstract class Player implements GameObject {
    protected String playerName;
    protected int health;
    protected int maxHealth;
    protected int attackPower;
    protected boolean isAlive = true;
    public Player(String playerName, int health, int attackPower) {
        this.playerName = playerName;
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
        this.health -= damage;
        if (health <= 0) {
            die();
        }

        System.out.println("| player " + this.playerName + "got hit by " + damage);
    }

    @Override
    public void die() {
        isAlive = false;

        System.out.println("| player " + this.playerName + "died");
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
}
