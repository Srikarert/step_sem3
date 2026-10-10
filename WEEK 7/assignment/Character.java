public class Character {
    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        health = health - amount;
        if (health < 0) {
            health = 0;
        }
    }

    public void heal(int amount) {
        health = health + amount;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("After 30 damage: health = " + c.getHealth());
        c.heal(50);
        System.out.println("After 50 heal: health = " + c.getHealth());
        c.takeDamage(150);
        System.out.println("After 150 damage: health = " + c.getHealth());

        Character c2 = new Character(50);
        c2.heal(10);
        System.out.println("c2 heal 10 on max 50: " + c2.getHealth());
    }
}
