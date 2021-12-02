package fm.tournament;

public class Viking extends Fighter implements IFighter {

    public Viking() {
        hitPoints = 120;
    }

    @Override
    public void engage(IFighter opponent) {

    }

    @Override
    public int hitPoints() {
        return 0;
    }

    @Override
    public Viking equip(String equipment) {
        return this;
    }
}
