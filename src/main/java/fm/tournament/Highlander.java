package fm.tournament;

public class Highlander extends Fighter implements IFighter {

    // counter for the great sword
    private int nbTimesUsed;

    public Highlander() {
        hitPoints = 150;
        inflictedDamage = 12;
    }

    public Highlander(String detail) {
        this();
    }

    public Highlander equip(String equipment) {
        equipmentList.add(equipment);
        return this;
    }

    public void blow(IFighter opponent) {
        nbTimesUsed++;

        // the great sword works 2 times on 3
        if (nbTimesUsed < 3)
            opponent.reduceHitPoints(inflictedDamage);
        else nbTimesUsed = 0;
    }
}
