public class Character
{
    private final int baseHealth = 5;
    private final int baseAttack = 5;
    private final int baseMagicAttack = 5;
    private final int baseDefense = 5;
    private final int baseMagicDefense = 5;
    private final int baseAgility = 5;
    private final int baseLuck = 5;
    private final int baseStrength= 0;
    private final int baseMana= 50;
    private final int baseMana_reg = 5;

    private int health = 5;
    private int attack = 5;
    private int magicAttack = 5;
    private int defense = 5;
    private int magicDefense = 5;
    private int agility = 5;
    private int luck = 5;
    private int strength;
    private int mana;
    private int mana_reg;


    //getter methoden
    public int getAttack()
    {
        return attack;
    }
    public int getHealth()
    {
        return health;
    }
    public int getMagicAttack()
    {
        return magicAttack;
    }
    public int getDefense()
    {
        return defense;
    }
    public int getMagicDefense()
    {
        return magicDefense;
    }
    public int getAgility()
    {
        return agility;
    }
    public int getLuck()
    {
        return luck;
    }
    public int getStrength()
    {
        return strength;
    }
    public int getMana()
    {
        return mana;
    }
    public int getMana_reg()
    {
        return mana_reg;
    }

    //Setter Methoden
    public void setHealth(int newHealth) { health = Math.max(newHealth, 0); }
    public void setDefense(int newDefense) { defense = Math.max(newDefense, 0); }
    public void setMagicDefense(int newMagicDefense) { magicDefense = Math.max(newMagicDefense, 0); }
    public void setAttack(int newAttack) { attack = Math.max(newAttack, 0); }
    public void setMagicAttack(int newMagicAttack) { magicAttack = Math.max(newMagicAttack, 0); }
    public void setAgility(int newAgility) { agility = Math.max(newAgility, 0); }
    public void setLuck(int newLuck) { luck = Math.max(newLuck, 0); }
    public void setStrength(int newStrength) { luck = Math.max(newStrength, 0); }
    public void setMana(int newMana) { luck = Math.max(newMana, 0); }
    public void setMana_reg(int newMana_reg) { luck = Math.max(newMana_reg, 0); }
}

