package fm.tournament;

public class Highlander extends Fighter implements IFighter {

    public Highlander() {
        hitPoints = 150;
    }

    public Highlander(String detail) {
        this();
    }

    @Override
    public void blow(IFighter opponent) {

    }

    public Highlander equip(String equipment) {
        equipmentList.add(equipment);
        return this;
    }
}
