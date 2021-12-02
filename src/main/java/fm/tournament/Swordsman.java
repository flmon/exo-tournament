package fm.tournament;

public class Swordsman extends Fighter implements IFighter {

    public Swordsman() {
        hitPoints = 100;
    }

    public Swordsman(String detail) {
        this();
        System.out.println("Swordsman with specialty");
    }

    @Override
    public void engage(IFighter opponent) {

    }

    @Override
    public int hitPoints() {
        return 0;
    }

    @Override
    public Swordsman equip(String equipment) {
        equipmentList.add(1);
        return this;
    }
}
