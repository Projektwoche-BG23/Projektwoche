/**
 *
 */
public class Enemy {

    private int health;         //Health value of the Unit
    private int defense;        //defense of the Unit in %
    private int spec_defense;   //special (Magic) defense of the Unit in %
    private int attack;         //Flat attack of the Unit
    private int spec_attack;    //Flat special (Magic) damage of the Unit
    private int agility;        //Agility of the Unit

    public Enemy(String enemyName){
        if(enemyName .equals("Skeleton")){
            health = 100;
            defense = 10;
            spec_defense = 20;
            attack = 15;
            spec_attack = 0;
            agility = 10;
        }
        else if (enemyName .equals("Goblin")) {

        }
    }

    /**
     * Outputs the Health value o the Enemy Unit
     * @return healt as int
     */
    public int getEnemyHealth(){
        return health;
    }
    /**
     * Outputs the Defense Value of the Enemy Unit
     * @return defense as int
     */
    public int getEnemyDefense(){
        return defense;
    }
    /**
     * Outputs the Special (Magic) defense of the Enemy Unit
     * @return spec_health as int
     */
    public int getEnemySpec_Defense(){
        return spec_defense;
    }

    /**
     * Outputs the Attack Value of the enemy Unit
     * @return attack as int
     */
    public int getEnemyAttack(){
        return attack;
    }
    /**
     * Outputs the Special (Magic) Attack Value of the enemy Unit
     * @return spec_attack as int
     */
    public int getEnemySpec_Attack(){
        return spec_attack;
    }
    /**
     * Outputs the Agility Value of the enemy Unit
     * @return agility as int
     */
    public int getEnemyAgility(){
        return agility;
    }

}
