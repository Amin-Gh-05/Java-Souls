package sbu.cs;

public abstract class Monster implements GameObject {
    protected int health;
    protected int maxHealth;
    protected int attackPower;
    protected boolean isAlive = true;
    public Monster(int health, int attackPower) {
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
        health -= damage;
        if (health <= 0) {
            die();
        }
    }

    @Override
    public void die() {
        isAlive = false;
    }
}
