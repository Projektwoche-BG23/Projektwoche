public class ItemsDictionary {

    Object[] items(String name)
    {
        switch(name)
        {
            default:
                return null;
            case "healthPotion":
                Object[] healthPotion = new Object[3];
                healthPotion[0] = "Health Potion"; //Name
                healthPotion[1] = "Increases health by 10."; //Beschreibung
                healthPotion[2] = 10; //Um wie viel
                return healthPotion;
            case "manaPotion":
                Object[] manbaPotion = new Object[3];
                manbaPotion[0] = "Mana Potion"; //Name
                manbaPotion[1] = "Increases mana by 10."; //Beschreibung
                manbaPotion[2] = 10; //Um wie viel
                return manbaPotion;
            case "luckPotion":
                Object[] luckPotion = new Object[3];
                luckPotion[0] = "Luck Potion"; //Name
                luckPotion[1] = "Increases luck by 2."; //Beschreibung
                luckPotion[2] = 2; //Um wie viel
                return luckPotion;
        }

    }

}
