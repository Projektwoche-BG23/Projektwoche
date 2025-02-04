
/**
 * Class to calculate the damage dealt or taken during combat.
 */
public class RechnerKampf {

    /**
     * Calculates the damage the Player does to an Enemy with a Normal attack
     * and decreases the health of the enemy accordingly
     * @param main Player Character
     * @param typ enemy that is attacked
     */
    public void playerAttack(Character main,Enemy typ)
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
    public void playerMagicAttack(Character main, Enemy typ)
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
    public void enemyAttack(Character main,Enemy typ)
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
    public void enemyMagicAttack(Character main, Enemy typ)
    {
        int tempdmg;
        int truedmg;
        tempdmg = Math.round(typ.getMagicAttack()*(main.getMagicDefense()/100.0f));
        truedmg = typ.getMagicAttack()-tempdmg;
        main.setHealth(main.getHealth()-truedmg);
    }
}

