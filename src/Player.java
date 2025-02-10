import java.sql.SQLException;

public class Player {
    public DB db;
    // Base Stats
    private final int baseAttack = 30;
    private final int baseMagicAttack = 40;
    private final int baseDefense = 10;
    private final int baseMagicDefense = 10;
    private final int baseAgility = 20;
    private final int baseLuck = 15;
    private final int baseStrength = 0;
    private final int baseManaReg = 5;
    private final int manaCost = 20;
    private final int baseMaxHealth = 80;
    private final int baseMaxMana = 50;

    // Current Stats
    private int health = 6000;
    private int attack = 30;
    private int magicAttack = 20;
    private int defense;
    private int magicDefense;
    private int agility = 60;
    private int luck;
    private int strength;
    private int mana = 50;
    private int manaReg;
    private int maxHealth;
    private int maxMana;
    private int tempStrength;       //Do not save it in database, it resets after every fight.
    private int potionCooldown = 0;

    public void joinUpdate(int userID) throws SQLException {
        update(userID);
        health = maxHealth;
        mana = maxMana;
    }
    public void update(int userID) throws SQLException
    {
        maxHealth = baseMaxHealth;
        attack = baseAttack;
        magicAttack = baseMagicAttack;
        defense = baseDefense;
        magicDefense = baseMagicDefense;
        agility = baseAgility;
        luck = baseLuck;
        strength = baseStrength;
        maxMana = baseMaxMana;
        manaReg = baseManaReg;

        String[] equippedItems = db.getEquipped(userID);

        for (String itemIDString : equippedItems) {
            if (itemIDString != null && !itemIDString.isEmpty()) {
                int itemID = Integer.parseInt(itemIDString);  // Item-ID from the slot
                String[] itemStats = db.itemInfo(itemID);  // get the item information from the database


                maxHealth += Integer.parseInt(itemStats[7]);
                attack += Integer.parseInt(itemStats[13]);
                magicAttack += Integer.parseInt(itemStats[11]);
                defense += Integer.parseInt(itemStats[4]);
                magicDefense += Integer.parseInt(itemStats[5]);
                agility += Integer.parseInt(itemStats[6]);
                luck += Integer.parseInt(itemStats[12]);
                strength += Integer.parseInt(itemStats[14]);
                maxMana += Integer.parseInt(itemStats[9]);
                manaReg += Integer.parseInt(itemStats[10]);
            }
        }
        attack += Math.round(attack+attack*strength);

    }

    // Get Methods
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
    public int getManaCost() { return  manaCost; }
    public int getMaxMana() { return  maxMana; }
    public int getMaxHealth() { return  maxHealth; }


    // Set Methods
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

    /**
     * checks if potion has still effects on.
     */
    public void countpotion(){
        if((potionCooldown)>0){
            potionCooldown--;
        }
        else{
            attack -= tempStrength;
        }
    }

    /**
     * Calculates and increases the potion buffs on top of the player stats.
     * @param itemID id of the potion
     * @throws SQLException
     */
    public void usePotion(String itemID) throws SQLException {
        Object[] itemInfo = db.itemInfo(Integer.parseInt(itemID));
        String werte = (String)itemInfo[15];
        int potionValue = Integer.parseInt(werte);

        switch (Integer.parseInt(itemID)){
            case 25,26:
                if((health + potionValue)>maxHealth){
                    health = maxHealth;
                }
                else health += potionValue;
                break;
            case 27:
                if((mana + potionValue)>maxMana){
                    mana = maxMana;
                }
                else mana += potionValue;
                break;
            case 28:
                strength += potionValue;
                int addAttack = Math.round(potionValue);
                attack += addAttack;
                tempStrength = addAttack;
                potionCooldown = 3;
                break;
        }
    }

}
