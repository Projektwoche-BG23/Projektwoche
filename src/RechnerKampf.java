
/**
 * Class to calculate the damage dealt or taken during combat.
 */
public class RechnerKampf {

    private Character character;

    public RechnerKampf(Character character) {
        this.character = character;
    }

    /**
     * Calculates the damage dealt by a normal attack.
     */
    private void attack(Character attacker, Character defender) {
        int dmg = attacker.getAttack() - (defender.getDefense() * 100 / attacker.getAttack());
        defender.setHealth(defender.getHealth() - dmg);
    }

    /**
     * Calculates the damage dealt by a special attack.
     */
    private void specialAttack(Character attacker, Character defender) {
        int dmg = (attacker.getAttack() * 2) - (defender.getDefense() * 100 / attacker.getAttack());
        defender.setHealth(defender.getHealth() - dmg);
    }

    /**
     * Calculates the damage dealt by a magic attack.
     */
    private void magicAttack(Character attacker, Character defender) {
        int dmg = attacker.getAttack() - (defender.getSpecDefense() * 100 / attacker.getAttack());
        defender.setHealth(defender.getHealth() - dmg);
    }
}
