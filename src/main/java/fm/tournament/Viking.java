package fm.tournament;

public class Viking extends Fighter implements IFighter {

    public Viking() {
        hitPoints = 120;
        inflictedDamage = 6;
        equip(AXE);
    }

    public Viking equip(String equipment) {
        equipmentList.add(equipment);
        return this;
    }
}
