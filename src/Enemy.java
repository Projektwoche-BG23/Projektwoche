/**
 * This class contains all enemy types and their base values.
 * Values can be changed and accessed using getter and setter methods.
 */
public class Enemy {

    private int health;         // Health points
    private int defense;        // Defense in %
    private int magicDefense;   // Magic Defense in %
    private int attack;         // Flat attack
    private int magicAttack;    // Flat Magic damage
    private int agility;        // Speed in turns and dodge chance at higher values
    private int luck;           // Critical hit chance
    private int cooldown;       // Determines the cooldown fo a Magic attack
    private int attackTyp;      // Determines what attack type the Unit can use.
    // 1 for Normal, 2 for Magic and 0 for both
    /**
     * Creates a new Enemy unit based on the given type.
     * @param enemyName Determines the enemy type. Available: SKELETON, GOBLIN, GHOST, KING
     */
    public Enemy(String enemyName) {
        switch (enemyName.toUpperCase()) {
            case "SKELETON":
                health = 100;
                defense = 10;
                magicDefense = 20;
                attack = 15;
                magicAttack = 0;
                agility = 10;
                luck = 10;
                attackTyp = 1;
                break;

            case "GOBLIN":
                health = 150;
                defense = 20;
                magicDefense = 10;
                attack = 25;
                magicAttack = 0;
                agility = 20;
                luck = 15;

                break;
            case "GHOST":
                health = 175;
                defense = 50;
                magicDefense = 0;
                attack = 0;
                magicAttack = 30;
                agility = 25;
                luck = 20;
                break;
            case "KING":
                health = 400;
                defense = 25;
                magicDefense = 25;
                attack = 30;
                magicAttack = 30;
                agility = 15;
                luck = 10;
                break;

            case "DRUNKEN_KNIGHT":
                health = 50;
                defense = 0;
                magicDefense = 0;
                attack = 5;
                magicAttack = 0;
                agility = 5;
                luck = 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid enemy type: " + enemyName);
        }
    }

    // Getter methods
    public int getHealth() { return health; }
    public int getDefense() { return defense; }
    public int getMagicDefense() { return magicDefense; }
    public int getAttack() { return attack; }
    public int getMagicAttack() { return magicAttack; }
    public int getAgility() { return agility; }
    public int getLuck() { return luck; }
    public int getAttackTyp(){ return attackTyp;}
    public int getCooldown(){ return cooldown;}
    // Setter methods
    public void setHealth(int newHealth) { health = Math.max(newHealth, 0); }
    public void setDefense(int newDefense) { defense = Math.max(newDefense, 0); }
    public void setMagicDefense(int newSpecDefense) { magicDefense = Math.max(newSpecDefense, 0); }
    public void setAttack(int newAttack) { attack = Math.max(newAttack, 0); }
    public void setMagicAttack(int newSpecAttack) { magicAttack = Math.max(newSpecAttack, 0); }
    public void setAgility(int newAgility) { agility = Math.max(newAgility, 0); }
    public void setLuck(int newLuck) { luck = Math.max(newLuck, 0); }

}

