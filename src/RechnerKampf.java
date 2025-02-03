/**
 * Class to find out how much Damage U make or take
 */
public class RechnerKampf
{
    Character c = new Character();
    /**
     * Methode um zu gucken wie viel Schaden der Gegner nimmt.
     */

    private void attack()
    {
        //int dmg = Attacker.getAttack-(held.getAttack * 100 / defender.getDefense);
        //defender.setHealth(defender.getHealth - dmg);
    }
    private void specialAttack()
    {
        //int dmg = (Attacker.getAttack * 2)-(held.getAttack * 100 / defender.getDefense);
        //defender.setHealth(defender.getHealth - dmg);
    }
    private void magicAttack()
    {
        //int dmg = Attacker.getAttack-(held.getAttack * 100 / defender.getSpec_Defense);
        //defender.setHealth(defender.getHealth - dmg);
    }

}
