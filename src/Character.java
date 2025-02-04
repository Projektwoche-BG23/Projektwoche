public class Character
{
    private int health = 5;
    private int attack = 5;
    private int specialAttack = 5;
    private int defense = 5;
    private int specialDefense = 5;
    private int agility = 5;
    private int luck = 5;
    private int strength;
    private int mana;
    private int mana_reg;

    private int baseHealth = 5;
    private int baseAttack = 5;
    private int baseSpecialAttack = 5;
    private int baseDefense = 5;
    private int baseSpecialDefense = 5;
    private int baseAgility = 5;
    private int baseLuck = 5;
    private int baseStrength;
    private int baseMana;
    private int baseMana_reg;

    //getter methoden
    public int getAttack()
    {
        return attack;
    }
    public int getHealth()
    {
        return health;
    }
    public int getSpecialAttack()
    {
        return specialAttack;
    }
    public int getDefense()
    {
        return defense;
    }
    public int getSpecialDefense()
    {
        return specialDefense;
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
    public void setSpecDefense(int newSpecDefense) { specialDefense = Math.max(newSpecDefense, 0); }
    public void setAttack(int newAttack) { attack = Math.max(newAttack, 0); }
    public void setSpecAttack(int newSpecAttack) { specialAttack = Math.max(newSpecAttack, 0); }
    public void setAgility(int newAgility) { agility = Math.max(newAgility, 0); }
    public void setLuck(int newLuck) { luck = Math.max(newLuck, 0); }
    public void setStrength(int newStrength) { luck = Math.max(newStrength, 0); }
    public void setMana(int newMana) { luck = Math.max(newMana, 0); }
    public void setMana_reg(int newMana_reg) { luck = Math.max(newMana_reg, 0); }
}

