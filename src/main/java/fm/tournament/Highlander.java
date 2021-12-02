package fm.tournament;

public class Highlander extends Fighter implements IFighter {

    public Highlander() {
        hitPoints = 150;
    }

    public Highlander(String detail) {
        this();
    }

    @Override
    public void engage(IFighter opponent) {

    }

    @Override
    public int hitPoints() {
        return 0;
    }

    @Override
    public IFighter equip(String equipment) {
        return this;
    }
}
