/**
 * This class contains all enemy types and their base values.
 * Values can be changed and accessed using getter and setter methods.
 */
public class Enemy {

    private int health;         // Health value of the unit
    private int defense;        // Defense of the unit in %
    private int specDefense;    // Special (Magic) defense of the unit in %
    private int attack;         // Flat attack of the unit
    private int specAttack;     // Flat special (Magic) damage of the unit
    private int agility;        // Agility of the unit

    /**
     * Creates a new Enemy unit based on the given type.
     * @param enemyName Determines the enemy type. Available: SKELETON, GOBLIN, GHOST, KING
     */
    public Enemy(String enemyName) {
        switch (enemyName.toUpperCase()) {
            case "SKELETON":
                health = 100;
                defense = 10;
                specDefense = 20;
                attack = 15;
                specAttack = 0;
                agility = 10;
                break;
            case "GOBLIN":
                health = 150;
                defense = 20;
                specDefense = 10;
                attack = 25;
                specAttack = 0;
                agility = 20;
                break;
            case "GHOST":
                health = 175;
                defense = 50;
                specDefense = 0;
                attack = 0;
                specAttack = 30;
                agility = 25;
                break;
            case "KING":
                health = 400;
                defense = 25;
                specDefense = 25;
                attack = 30;
                specAttack = 30;
                agility = 15;
                break;
            default:
                throw new IllegalArgumentException("Invalid enemy type: " + enemyName);
        }
    }

    // Getter methods
    public int getHealth() { return health; }
    public int getDefense() { return defense; }
    public int getSpecDefense() { return specDefense; }
    public int getAttack() { return attack; }
    public int getSpecAttack() { return specAttack; }
    public int getAgility() { return agility; }

    // Setter methods
    public void setHealth(int newHealth) { health = Math.max(newHealth, 0); }
    public void setDefense(int newDefense) { defense = Math.max(newDefense, 0); }
    public void setSpecDefense(int newSpecDefense) { specDefense = Math.max(newSpecDefense, 0); }
    public void setAttack(int newAttack) { attack = Math.max(newAttack, 0); }
    public void setSpecAttack(int newSpecAttack) { specAttack = Math.max(newSpecAttack, 0); }
    public void setAgility(int newAgility) { agility = Math.max(newAgility, 0); }
}

