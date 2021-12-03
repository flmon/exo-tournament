package fm.tournament;

public class Viking extends Fighter implements IFighter {

    public Viking() {
        hitPoints = 120;
        inflictedDamage = 6;
    }

    @Override
    public Viking equip(String equipment) {
        return this;
    }
}
