
import java.sql.SQLException;
import java.util.Random;

/**
 * Class to calculate the damage dealt or taken during combat.
 *
 */
public class RechnerKampf {

    private int attackCooldown = 0;     //Counts the rounds after a special attack after it used on an enemy.
    private int manaControll = 0;       //If the player does not have enough mana and wanst to use magic, the Round will not start.
    Random attackRNG = new Random();
    Inventory inventory = new Inventory();
    /**
     * Manages a complete round of Fighting
     * @param player Player Object
     * @param aktion Type of attack (Normal or Magic)
     * @param enemy  Enemy Object
     */

    public void fight(Player player, String aktion, Enemy enemy){
        if(aktion .equalsIgnoreCase("Magic") && player.getMana()< player.getManaCost()){
            manaControll = 1;
            System.err.println("Player does not have enough mana!");
        }
        else {
            manaControll = 0;
        }

        if(manaControll == 0) {
            player.countpotion();
            if (attackCooldown != 0) {
                attackCooldown--;
            }
            if (player.getAgility() > enemy.getAgility()) {
                playerAttackType(player, aktion, enemy);
                if (enemy.getHealth() > 0) {
                    enemyAttackType(player, enemy);
                }
            }
            if (player.getAgility() < enemy.getAgility()) {
                enemyAttackType(player, enemy);
                if (player.getHealth() > 0) {
                    playerAttackType(player, aktion, enemy);
                }
            }
            if(player.getAgility() == enemy.getAgility()){
                int rngInt = attackRNG.nextInt(1,3);
                if(rngInt == 1){
                    playerAttackType(player, aktion, enemy);
                    if (enemy.getHealth() > 0) {
                        enemyAttackType(player, enemy);
                    }
                }
                else{
                    enemyAttackType(player, enemy);
                    if (player.getHealth() > 0) {
                        playerAttackType(player, aktion, enemy);
                    }
                }
            }
            if(player.getMana()<player.getMaxMana()){
                player.setMana(player.getMana()+player.getManaReg());
            }
        }
    }

    /**
     * This methode runs when Player uses an item. It costs a round.
     * @param itemID Item id that has been used.
     * @param player Character bject
     * @param enemy Enemy Object
     * @throws SQLException
     */
    public void itemConsumtion(String itemID, Player player, Enemy enemy) throws SQLException {
        inventory.consum(itemID,player);
        fight(player,"",enemy);
    }
    /**
     * Determines what type of attack the player wants to use
     * @param player Player Object
     * @param attack Type of attack input from fight
     * @param enemy  Enemy Object
     */
    private void playerAttackType(Player player, String attack, Enemy enemy){
        if(attack .equalsIgnoreCase("normal")){
            playerAttack(player,enemy);
        }
        else if(attack .equalsIgnoreCase("magic")){
            playerMagicAttack(player, enemy);
        }
    }

    /**
     * Determines what type of attack the enemy uses
     * @param player Player Object
     * @param enemy  Enemy Object
     */
    private void enemyAttackType(Player player, Enemy enemy){
        if(enemy.getAttackTyp() == 1){
            enemyAttack(player,enemy);
        }
        else if (enemy.getAttackTyp() == 2) {
            enemyMagicAttack(player,enemy);
        }
        else{
            kingAttacktype(player,enemy);
        }
    }

    /**
     * Determines what attack the King will do. If the Special attack is on cooldown only normal attacks will work.
     * @param player Player Object
     * @param enemy Enemy Object
     */
    private void kingAttacktype(Player player, Enemy enemy){
        if(attackCooldown==0){

            int rngNumber = attackRNG.nextInt(1,3);
            if(rngNumber == 1){
                enemyAttack(player,enemy);
            }
            else{
                enemyMagicAttack(player,enemy);
                attackCooldown = enemy.getCooldown();
            }
        }
    }

    /**
     * While the fight is still ongoing this will say true
     * When one of the Opponents has 0 HP, The fight is over and this will say false
     * @param player Player Object
     * @param enemy Enemy Object
     * @return
     */
    public boolean fightStatus(Player player, Enemy enemy){
        if(player.getHealth()>0 && enemy.getHealth()>0){
            return true;
        }
        else{
            attackCooldown = 0;
            return false;
        }
    }

    /**
     * Calculates the damage the Player does to an Enemy with a Normal attack
     * and decreases the health of the enemy accordingly
     * @param main Player
     * @param typ enemy that is attacked
     */

    private void playerAttack(Player main, Enemy typ)
    {
        int luckInt = attackRNG.nextInt(1,101);

        int tempdmg;
        int truedmg;
        tempdmg = Math.round(main.getAttack()*(typ.getDefense()/100.0f));
        truedmg = main.getAttack()-tempdmg;
        if(luckInt <= main.getLuck()){
            typ.setHealth(typ.getHealth() - 2*truedmg);
        }
        else {
            typ.setHealth(typ.getHealth() - truedmg);
        }

    }

    /**
     * Calculates the damage the Player does to an Enemy with a Magic attack
     * and decreases the health of the enemy accordingly
     * @param main Player
     * @param typ enemy that is attacked
     */
    private void playerMagicAttack(Player main, Enemy typ)
    {
        int luckInt = attackRNG.nextInt(1,101);

        int tempdmg;
        int truedmg;
        tempdmg = Math.round(main.getMagicAttack()*(typ.getMagicDefense()/100.0f));
        truedmg = main.getMagicAttack()-tempdmg;
        if(luckInt <= main.getLuck()){
            typ.setHealth(typ.getHealth() - 2*truedmg);
        }
        else {
            typ.setHealth(typ.getHealth() - truedmg);
        }

    }

    /**
     * Calculates the damage the Enemy does to the Player with a Normal attack
     * and decreases the health of the Player accordingly
     * @param main Player
     * @param typ enemy that is attacking
     */
    private void enemyAttack(Player main, Enemy typ)
    {
        int luckInt = attackRNG.nextInt(1,101);

        int tempdmg;
        int truedmg;
        tempdmg = Math.round(typ.getAttack()*(main.getDefense()/100.0f));
        truedmg = typ.getAttack()-tempdmg;
        if(luckInt <= typ.getLuck()){
            main.setHealth(main.getHealth() - 2*truedmg);
        }
        else {
            main.setHealth(main.getHealth() - truedmg);
        }

    }

    /**
     * Calculates the damage the Enemy does to the Player with a Magic attack
     * and decreases the health of the Player accordingly
     * @param main Player
     * @param typ enemy that is attacking
     */
    private void enemyMagicAttack(Player main, Enemy typ)
    {
        int luckInt = attackRNG.nextInt(1,101);

        int tempdmg;
        int truedmg;
        tempdmg = Math.round(typ.getMagicAttack()*(main.getMagicDefense()/100.0f));
        truedmg = typ.getMagicAttack()-tempdmg;
        if(luckInt <= typ.getLuck()){
            main.setHealth(main.getHealth() - 2*truedmg);
        }
        else {
            main.setHealth(main.getHealth() - truedmg);
        }

    }
}
