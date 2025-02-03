/**
 *  This class contains all enemy types and there Base values. Values can be changed and called by set and get funktions
 */
public class Enemy {

    private int health;         //Health value of the Unit
    private int defense;        //defense of the Unit in %
    private int spec_defense;   //special (Magic) defense of the Unit in %
    private int attack;         //Flat attack of the Unit
    private int spec_attack;    //Flat special (Magic) damage to the Unit
    private int agility;        //Agility of the Unit

    /**
     * Ths creates a new Enemy Unit
     * @param enemyName determins the enemy Type. Available are SKELETON, GOBLIN, GHOST and KING
     */
    public Enemy(String enemyName){
        if(enemyName .equals("SKELETON")){
            health = 100;
            defense = 10;
            spec_defense = 20;
            attack = 15;
            spec_attack = 0;
            agility = 10;
        }
        else if (enemyName .equals("GOBLIN")) {
            health = 150;
            defense = 20;
            spec_defense = 10;
            attack = 25;
            spec_attack = 0;
            agility = 20;
        } else if (enemyName .equals("GHOST")) {
            health = 175;
            defense = 50;
            spec_defense = 0;
            attack = 0;
            spec_attack = 30;
            agility = 25;
        } else if (enemyName .equals("KING")) {
            health = 400;
            defense = 25;
            spec_defense = 25;
            attack = 30;
            spec_attack = 30;
            agility = 15;
        }
        else{
            System.err.println("Gbeinen Validen Gegner Typ ein");
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
     * @param newAttack new Attack value as int
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
     * Sets a new Special Attack (Magic) Value to an enemy Unit
     * If the new Special Attack (Magic) Value is below 0, it is set to 0.
     * @param newSpec_Attack new Special Attack value as int
     */
    public void setEnemySpec_Attack(int newSpec_Attack) {
        if(newSpec_Attack>=0){
            spec_attack = newSpec_Attack;
        }
        else{
            spec_defense=0;
        }
    }
    /**
     * Sets a new Defense Value to an enemy Unit
     * If the new Defense Value is below 0, it is set to 0.
     * @param newDefense new Defense value as int
     */
    public void setEnemyDefense(int newDefense) {
        if(newDefense>=0){
            attack = newDefense;
        }
        else{
            attack=0;
        }
    }
    /**
     * Sets a new Special Defense (Magic) Value to an enemy Unit
     * If the new Special Defense (Magic) Value is below 0, it is set to 0.
     * @param newSpec_Defense new Special Defense value as int
     */
    public void setEnemySpec_Defense(int newSpec_Defense) {
        if(newSpec_Defense>=0){
            spec_attack = newSpec_Defense;
        }
        else{
            spec_defense=0;
        }
    }
    /**
     * Sets a new Special Attack (Magic) Value to an enemy Unit
     * If the new Special Attack (Magic) Value is below 0, it is set to 0.
     * @param newAgility new Agility value as int
     */
    public void setEnemyAgility(int newAgility) {
        if(newAgility>=0){
            spec_attack = newAgility;
        }
        else{
            spec_defense=0;
        }
    }

}
