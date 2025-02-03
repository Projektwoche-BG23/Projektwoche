/**
 *
 */
public class Enemy {

    private int health;         //Health value of the Unit
    private int defense;        //defense of the Unit in %
    private int spec_defense;   //special (Magic) defense of the Unit in %
    private int attack;         //Flat attack of the Unit
    private int spec_attack;    //Flat special (Magic) damage to the Unit
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

    /**
     * Set a new Health Value to an Enemy Unit.
     * If the new Health Value is below 0, it is set to 0.
     * @param newHealth new Helath value as int
     */
    public void setEnemyHealth(int newHealth) {
        if(newHealth>=0){
            health = newHealth;
        }
        else{
            health=0;
        }
    }
    /**
     * Sets a new Attack Value to an enemy Unit
     * If the new Attack Value is below 0, it is set to 0.
     * @param newAttack new attack value as int
     */
    public void setEnemyAttack(int newAttack) {
        if(newAttack>=0){
            attack = newAttack;
        }
        else{
            attack=0;
        }
    }
    /**
     * Sets a new Defense Value to an enemy Unit
     * If the new Defense Value is below 0, it is set to 0.
     * @param newDefense new defense value as int
     */
    public void setEnemyDefense(int newDefense) {
        if(newDefense>=0){
            attack = newDefense;
        }
        else{
            attack=0;
        }
    }

}
