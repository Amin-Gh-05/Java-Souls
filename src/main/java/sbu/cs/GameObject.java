package sbu.cs;

public interface GameObject {
    void attack(GameObject target);

    void takeDamage(int damage);

    void die();
}
