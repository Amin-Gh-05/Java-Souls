package sbu.cs;

public abstract class Monster implements GameObject {
    protected final String type;
    protected int health;
    protected int maxHealth;
    protected int attackPower;
    protected boolean isAlive = true;

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
            System.out.println("| " + this.type + " got hit by " + damage);
            System.out.println("| " + this.type + "'s health is " + this.health);
            if (health <= 0) {
                die();
            }
        }
    }

    @Override
    public void die() {
        isAlive = false;
        System.out.println("| " + this.type + " died");
    }
}
