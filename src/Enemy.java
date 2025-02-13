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
     *
     * Creates a new Enemy unit based on the given type.
     * @param enemyName Determines the enemy type. Available: SKELETON, GOBLIN, GHOST, KING
     */
    public Enemy(String enemyName) {
        switch (enemyName.toUpperCase()) {
            //Values need to be changed here!!!!!!!!!!
            case "DRUNKENKNIGHT": //1
                health =25;
                defense =0;
                magicDefense =0;
                attack =5;
                magicAttack =0;
                agility =2;
                luck =1;
                attackTyp =1;
                break;
            case "WOLVES": //3
                health =45;
                defense =15;
                magicDefense =15;
                attack =10;
                magicAttack =0;
                agility =25;
                luck =5;
                attackTyp =1;
                break;
            case "SHADOWGUARDS": //
                health =60;
                defense =10;
                magicDefense =10;
                attack =15;
                magicAttack =20;
                agility =15;
                luck =10;
                attackTyp =0;
                cooldown = 2;
                break;
            case "ADVENTURER": //1
                health =70;
                defense =15;
                magicDefense =15;
                attack =15;
                magicAttack =20;
                agility =20;
                luck =10;
                attackTyp =0;
                cooldown = 2;
                break;
            case "AZROTH": //1
                health =150;
                defense =50;
                magicDefense =50;
                attack =35;
                magicAttack =0;
                agility =5;
                luck =0;
                attackTyp =1;
                break;
            case "ELITEKNIGHTS": //2
                health =70;
                defense =15;
                magicDefense =15;
                attack =25;
                magicAttack =30;
                agility =1;
                luck =1;
                attackTyp =1;
                break;
            case "CERBERUS": //1
                health =110;
                defense =30;
                magicDefense =25;
                attack =35;
                magicAttack =45;
                agility =1;
                luck =1;
                attackTyp =0;
                cooldown = 4;
                break;
            case "PRINCESSGUARD": //1
                health =70;
                defense =15;
                magicDefense =10;
                attack =30;
                magicAttack =0;
                agility =30;
                luck =10;
                attackTyp =1;
                break;
            case "GOBLIN": //3
                health =70;
                defense =10;
                magicDefense =10;
                attack =25;
                magicAttack =0;
                agility =30;
                luck =15;
                attackTyp =1;
                break;
            case "SKELETON": // 4
                health =80;
                defense =5;
                magicDefense =15;
                attack =25;
                magicAttack =0;
                agility =15;
                luck =5;
                attackTyp =1;
                break;
            case "SKELLETGUARD": //2
                health =100;
                defense =15;
                magicDefense =25;
                attack =25;
                magicAttack =0;
                agility =15;
                luck =10;
                attackTyp =1;
                break;
            case "KING": //1
                health =300;
                defense =20;
                magicDefense =20;
                attack =40;
                magicAttack =55;
                agility =5;
                luck =0;
                attackTyp =0;
                cooldown =4;
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

