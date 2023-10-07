public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private BattleLoc battleLoc;
    private boolean food;
    private boolean water;
    private boolean wood;

    public Inventory() {
        this.weapon = new Weapon("Yumruk", -1, 0, 0);
        this.armor = new Armor(-1, "Pacavra", 0, 0);


    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public BattleLoc getBattleLoc() {
        return battleLoc;
    }

    public void setBattleLoc(BattleLoc battleLoc) {
        this.battleLoc = battleLoc;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isWood() {
        return wood;
    }

    public void setWood(boolean wood) {
        this.wood = wood;
    }
}
