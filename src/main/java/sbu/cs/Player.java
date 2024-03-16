package sbu.cs;

public abstract class Player implements GameObject {
    protected String playerName;
    final protected String type;
    protected int health;
    protected int maxHealth;
    protected int attackPower;
    protected boolean isAlive = true;

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
            System.out.println("| player " + this.playerName + " got hit by " + damage);
            System.out.println("| player " + this.playerName + "'s health is " + this.health);
            if (health <= 0) {
                die();
            }
        }
    }

    @Override
    public void die() {
        isAlive = false;

        System.out.println("| player " + this.playerName + " died");
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
}
