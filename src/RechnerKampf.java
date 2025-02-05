import java.util.Random;

/**
 * Class to calculate the damage dealt or taken during combat.
 */
public class RechnerKampf {

    private int attackCooldown = 0;     // Counts the rounds after a special attack of an enemy is used
    private int manaControll = 0;       // If the player does not have enough mana and wanst to use magic, the Round will not start

    public void fight(Character player,String attack, Enemy enemy){
            if(attack .equalsIgnoreCase("Magic") && player.getMana()< player.getManaCost()){
                manaControll = 1;
                System.err.println("Spieler hat nicht genuzg mana");
            }
            else {
                manaControll = 0;
            }

            if(manaControll == 0) {
                if (attackCooldown != 0) {
                    attackCooldown--;
                }
                if (player.getAgility() > enemy.getAgility()) {
                    playerAttackType(player, attack, enemy);
                    if (enemy.getHealth() > 0) {
                        enemyAttackType(player, enemy);
                    }
                }
                if (player.getAgility() < enemy.getAgility()) {
                    enemyAttackType(player, enemy);
                    if (player.getHealth() > 0) {
                        playerAttackType(player, attack, enemy);
                    }
                }
            }
    }

    private void playerAttackType(Character player, String attack, Enemy enemy){
        if(attack .equalsIgnoreCase("normal")){
            playerAttack(player,enemy);
        }
        else if(attack .equalsIgnoreCase("magic")){
            playerMagicAttack(player, enemy);
        }
    }

    private void enemyAttackType(Character player, Enemy enemy){
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

    private void kingAttacktype(Character player, Enemy enemy){
        if(attackCooldown==0){
            Random attackRNG = new Random();
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

    private boolean fightStatus(Character player, Enemy enemy){
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
     * @param main Player Character
     * @param typ enemy that is attacked
     */

    private void playerAttack(Character main,Enemy typ)
    {
        int tempdmg;
        int truedmg;
        tempdmg = Math.round(main.getAttack()*(typ.getDefense()/100.0f));
        truedmg = main.getAttack()-tempdmg;
        typ.setHealth(typ.getHealth()-truedmg);
    }

    /**
     * Calculates the damage the Player does to an Enemy with a Magic attack
     * and decreases the health of the enemy accordingly
     * @param main Player Character
     * @param typ enemy that is attacked
     */
    private void playerMagicAttack(Character main, Enemy typ)
    {
        int tempdmg;
        int truedmg;
        tempdmg = Math.round(main.getMagicAttack()*(typ.getMagicDefense()/100.0f));
        truedmg = main.getMagicAttack()-tempdmg;
        typ.setHealth(typ.getHealth()-truedmg);
    }
    /**
     * Calculates the damage the Enemy does to the Player with a Normal attack
     * and decreases the health of the Player accordingly
     * @param main Player Character
     * @param typ enemy that is attacking
     */
    private void enemyAttack(Character main,Enemy typ)
    {
        int tempdmg;
        int truedmg;
        tempdmg = Math.round(typ.getAttack()*(main.getDefense()/100.0f));
        truedmg = typ.getAttack()-tempdmg;
        main.setHealth(main.getHealth()-truedmg);
    }
    /**
     * Calculates the damage the Enemy does to the Player with a Magic attack
     * and decreases the health of the Player accordingly
     * @param main Player Character
     * @param typ enemy that is attacking
     */
    private void enemyMagicAttack(Character main, Enemy typ)
    {
        int tempdmg;
        int truedmg;
        tempdmg = Math.round(typ.getMagicAttack()*(main.getMagicDefense()/100.0f));
        truedmg = typ.getMagicAttack()-tempdmg;
        main.setHealth(main.getHealth()-truedmg);
    }
}

