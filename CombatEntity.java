public abstract class CombatEntity {
    protected String name;
    protected int curHealth;
    protected int maxHealth;
    protected int basePower;

    public CombatEntity(String n, int h, int p) {
        name = n;
        maxHealth = h;
        basePower = p;
        curHealth = maxHealth;
    } 

    public boolean hasLost() {
        return curHealth <= 0;
    }

    public String takeHit(int damage, String source) {
        curHealth -= damage;
        return name + " takes a hit for " + damage + " damage from " + source;
    }

    public String recover(int amount, String source) {
        int amountR = amount;
        if (curHealth + amount > maxHealth) {
            amountR = maxHealth - curHealth;
            curHealth = maxHealth;
        } else {
            curHealth += amount;
        }
        return name + " recovers " + amountR + " health from " + source;
    }

    public String getName() {
        return name;
    }

    public int getCurHealth() {
        return curHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getBasePower() {
        return basePower;
    }

    public int getHealth() {
        return curHealth;
    }

    public void setHealth(int Health) {
        curHealth = Health;
    }

    public abstract String attack(CombatEntity target);
}