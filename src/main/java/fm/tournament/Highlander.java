package fm.tournament;

public class Highlander extends Fighter implements IFighter {
    private static final String VETERAN = "Veteran";

    private final int initialHitPoints = 150;

    // 30% of initial
    private final int veteranLimitHitPoints = 30 * initialHitPoints / 100;

    // counter for the great sword
    private int nbTimesUsed;

    private boolean veteranMode;

    //to reset damage when becoming berserk
    private boolean berserkDamageDone;

    public Highlander() {
        hitPoints = initialHitPoints;
        inflictedDamage = 12;
    }

    public Highlander(String detail) {
        this();
        if (detail.equals(VETERAN)) {
            veteranMode = true;
        }
    }

    public Highlander equip(String equipment) {
        equipmentList.add(equipment);
        return this;
    }

    private void updateDamage() {
        if (berserkDamageDone) return;

        if (hitPoints < veteranLimitHitPoints) {
            inflictedDamage *= 2;
            berserkDamageDone = true;
        }
    }

    public void blow(IFighter opponent) {
        if (veteranMode) updateDamage();

        nbTimesUsed++;

        // the great sword works 2 times on 3
        if (nbTimesUsed < 3)
            opponent.reduceHitPoints(inflictedDamage);
        else nbTimesUsed = 0;
    }
}
