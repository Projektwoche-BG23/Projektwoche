/**
 * This class contains all enemy types and their base values.
 * Values can be changed and accessed using getter and setter methods.
 */
public class Enemy {

    private int health;         // Health points
    private int defense;        // Defense in %
    private int specDefense;    // Magic Defense in %
    private int attack;         // Flat attack
    private int specAttack;     // Flat Magic damage
    private int agility;        // Speed in turns and dodge chance at higher values
    private int luck;           //Critical hit chance

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
                luck = 10;

                break;
				
            case "GOBLIN":
                health = 150;
                defense = 20;
                specDefense = 10;
                attack = 25;
                specAttack = 0;
                agility = 20;
                luck = 15;
            
                break;
            case "GHOST":
                health = 175;
                defense = 50;
                specDefense = 0;
                attack = 0;
                specAttack = 30;
                agility = 25;
                luck = 20;
                break;
            
            case "KING":
                health = 400;
                defense = 25;
                specDefense = 25;
                attack = 30;
                specAttack = 30;
                agility = 15;
                luck = 10;
                break;
            
            case "DRUNKEN_KNIGHT":
                health = 50;
                defense = 0;
                specDefense = 0;
                attack = 5;
                specAttack = 0;
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
    public int getSpecDefense() { return specDefense; }
    public int getAttack() { return attack; }
    public int getSpecAttack() { return specAttack; }
    public int getAgility() { return agility; }
    public int getLuck() { return luck; }

    // Setter methods
    public void setHealth(int newHealth) { health = Math.max(newHealth, 0); }
    public void setDefense(int newDefense) { defense = Math.max(newDefense, 0); }
    public void setSpecDefense(int newSpecDefense) { specDefense = Math.max(newSpecDefense, 0); }
    public void setAttack(int newAttack) { attack = Math.max(newAttack, 0); }
    public void setSpecAttack(int newSpecAttack) { specAttack = Math.max(newSpecAttack, 0); }
    public void setAgility(int newAgility) { agility = Math.max(newAgility, 0); }
  
    public void setLuck(int newLuck) { luck = Math.max(newLuck, 0); }
}

