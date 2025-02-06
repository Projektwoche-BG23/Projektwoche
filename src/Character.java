import java.security.PrivateKey;
import java.sql.SQLException;

public class Character {
    private DB db;
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
    private final int manaCost = 5;
    private final int baseMaxHealth = 5;
    private final int baseMaxMana = 5;

    // Current Stats
    private int health;
    private int attack;
    private int magicAttack;
    private int defense;
    private int magicDefense;
    private int agility;
    private int luck;
    private int strength;
    private int mana;
    private int manaReg;
    private int maxHealth;
    private int maxMana;
    private int tempStrength;       //Bitte hier nicht in datenbank speichern wird nach Kampf resettet
    private int potionCooldown = 0;

    public void Update(int UserID) throws SQLException
    {
        health = baseHealth;
        attack = baseAttack;
        magicAttack = baseMagicAttack;
        defense = baseDefense;
        magicDefense = baseMagicDefense;
        agility = baseAgility;
        luck = baseLuck;
        strength = baseStrength;
        mana = baseMana;
        manaReg = baseManaReg;

        String[] equippedItems = db.getEquipped(UserID);

        for (String itemIDString : equippedItems) {
            if (itemIDString != null && !itemIDString.isEmpty()) {
                int itemID = Integer.parseInt(itemIDString);  // Item-ID aus dem Slot
                String[] itemStats = db.itemInfo(itemID);  // Hole die Item-Informationen aus der DB


                health += Integer.parseInt(itemStats[7]);
                attack += Integer.parseInt(itemStats[13]);
                magicAttack += Integer.parseInt(itemStats[11]);
                defense += Integer.parseInt(itemStats[4]);
                magicDefense += Integer.parseInt(itemStats[5]);
                agility += Integer.parseInt(itemStats[6]);
                luck += Integer.parseInt(itemStats[12]);
                strength += Integer.parseInt(itemStats[14]);
                mana += Integer.parseInt(itemStats[9]);
                manaReg += Integer.parseInt(itemStats[10]);
            }
        }
    }

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
    public int getManaCost() { return  manaCost; }


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

    public void countpotion(){
        if((potionCooldown)>0){
            potionCooldown--;
        }
        else{
            attack -= tempStrength;
        }
    }
    public void usePotion(String itemID) throws SQLException {
        String[] itemInfo = db.itemInfo(Integer.parseInt(itemID));
        int potionValue = Integer.parseInt(itemInfo[15]);

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
