public class InventoryItem
{
    private String _itemId;
    public String itemName;

    public int maxHpModifier;
    public int maxManaModifier;
    public int attackModifier;
    public int defenseModifier;
    public int strengthModifier;
    public int agilityModifier;
    public int luckModifier;
    public int manaRegenModifier;

    public InventoryItem(String itemId, String itemName){
        _itemId = itemId;
        this.itemName = itemName;
    }
}


