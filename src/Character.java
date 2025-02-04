public class Character {
    // Base Stats
    private final int baseHealth = 5;
    private final int baseAttack = 5;
    private final int baseMagicAttack = 5;
    private final int baseDefense = 5;
    private final int baseMagicDefense = 5;
    private final int baseAgility = 5;
    private final int baseLuck = 5;
    private final int baseStrength = 0;
    private final int baseMana = 50;
    private final int baseManaReg = 5;

    // Current Stats
    private int health = baseHealth;
    private int attack = baseAttack;
    private int magicAttack = baseMagicAttack;
    private int defense = baseDefense;
    private int magicDefense = baseMagicDefense;
    private int agility = baseAgility;
    private int luck = baseLuck;
    private int strength = baseStrength;
    private int mana = baseMana;
    private int manaReg = baseManaReg;

    // Getter Methods
    public int getAttack() { return attack; }
    public int getHealth() { return health; }
    public int getMagicAttack() { return magicAttack; }
    public int getDefense() { return defense; }
    public int getMagicDefense() { return magicDefense; }
    public int getAgility() { return agility; }
    public int getLuck() { return luck; }
    public int getStrength() { return strength; }
    public int getMana() { return mana; }
    public int getManaReg() { return manaReg; }

    // Setter Methods
    public void setHealth(int newHealth) { health = Math.max(newHealth, 0); }
    public void setAttack(int newAttack) { attack = Math.max(newAttack, 0); }
    public void setMagicAttack(int newMagicAttack) { magicAttack = Math.max(newMagicAttack, 0); }
    public void setDefense(int newDefense) { defense = Math.max(newDefense, 0); }
    public void setMagicDefense(int newMagicDefense) { magicDefense = Math.max(newMagicDefense, 0); }
    public void setAgility(int newAgility) { agility = Math.max(newAgility, 0); }
    public void setLuck(int newLuck) { luck = Math.max(newLuck, 0); }
    public void setStrength(int newStrength) { strength = Math.max(newStrength, 0); }
    public void setMana(int newMana) { mana = Math.max(newMana, 0); }
    public void setManaReg(int newManaReg) { manaReg = Math.max(newManaReg, 0); }
}
