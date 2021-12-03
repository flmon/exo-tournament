package fm.tournament;

public class Swordsman extends Fighter implements IFighter {

    public Swordsman() {
        hitPoints = 100;
        inflictedDamage = 5;
    }

    public Swordsman(String detail) {
        this();
        System.out.println("Swordsman with specialty");
    }

    public Swordsman equip(String equipment) {
        equipmentList.add(equipment);
        return this;
    }
}
