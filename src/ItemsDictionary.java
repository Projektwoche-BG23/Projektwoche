public class ItemsDictionary {

    Object[] items(String name) {
        switch (name) {
            default:
                return null;
            case "healthPotion":
                Object[] healthPotion = new Object[4];
                healthPotion[0] = "Health Potion"; // Name
                healthPotion[1] = "Increases health by 10."; // Beschreibung
                healthPotion[2] = "health_potion"; // ID
                healthPotion[3] = 10; // Um wie viel
                return healthPotion;
            case "manaPotion":
                Object[] manaPotion = new Object[4];
                manaPotion[0] = "Mana Potion"; // Name
                manaPotion[1] = "Increases mana by 10."; // Beschreibung
                manaPotion[2] = "mana_potion"; // ID
                manaPotion[3] = 10; // Um wie viel
                return manaPotion;
            case "luckPotion":
                Object[] luckPotion = new Object[4];
                luckPotion[0] = "Luck Potion"; // Name
                luckPotion[1] = "Increases luck by 2."; // Beschreibung
                luckPotion[2] = "luck_potion"; // ID
                luckPotion[3] = 2; // Um wie viel
                return luckPotion;
        }
    }
}
