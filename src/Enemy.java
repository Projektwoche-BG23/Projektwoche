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
            //Values need to be changed here!!!!!!!!!!
            case "DRUNKENKNIGHT":
                health =1;
                defense =1;
                magicDefense =1;
                attack =1;
                magicAttack =1;
                agility =1;
                luck =1;
                attackTyp =1;
                break;
            case "GUARDS":
                health =1;
                defense =1;
                magicDefense =1;
                attack =1;
                magicAttack =1;
                agility =1;
                luck =1;
                attackTyp =1;
                break;
            case "WOLVES":
                health =1;
                defense =1;
                magicDefense =1;
                attack =1;
                magicAttack =1;
                agility =1;
                luck =1;
                attackTyp =1;
                break;
            case "SHADOWGUARDS":
                health =1;
                defense =1;
                magicDefense =1;
                attack =1;
                magicAttack =1;
                agility =1;
                luck =1;
                attackTyp =1;
                break;
            case "GHOSTWARRIOR":
                health =1;
                defense =1;
                magicDefense =1;
                attack =1;
                magicAttack =1;
                agility =1;
                luck =1;
                attackTyp =1;
                break;
            case "DARKTITANAZROTH":
                health =1;
                defense =1;
                magicDefense =1;
                attack =1;
                magicAttack =1;
                agility =1;
                luck =1;
                attackTyp =1;
                break;
            case "ELITEKNIGHTS":
                health =1;
                defense =1;
                magicDefense =1;
                attack =1;
                magicAttack =1;
                agility =1;
                luck =1;
                attackTyp =1;
                break;
            case "THREEHEADDOG":
                health =1;
                defense =1;
                magicDefense =1;
                attack =1;
                magicAttack =1;
                agility =1;
                luck =1;
                attackTyp =1;
                break;
            case "GOBLIN":
                health =1;
                defense =1;
                magicDefense =1;
                attack =1;
                magicAttack =1;
                agility =1;
                luck =1;
                attackTyp =1;
                break;
            case "BANDIT":
                health =1;
                defense =1;
                magicDefense =1;
                attack =1;
                magicAttack =1;
                agility =1;
                luck =1;
                attackTyp =1;
                break;
            case "ELITEGUARDS":
                health =1;
                defense =1;
                magicDefense =1;
                attack =1;
                magicAttack =1;
                agility =1;
                luck =1;
                attackTyp =1;
                break;
            case "SKELLETGUARD":
                health =1;
                defense =1;
                magicDefense =1;
                attack =1;
                magicAttack =1;
                agility =1;
                luck =1;
                attackTyp =1;
                break;
            case "KING":
                health =1;
                defense =1;
                magicDefense =1;
                attack =1;
                magicAttack =1;
                agility =1;
                luck =1;
                attackTyp =0;
                cooldown =1;
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

