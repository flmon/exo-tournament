package fm.tournament;

/**
 * @author Florian Monachon
 * <p>
 * This class is to define a specialized fighter
 */
public class Highlander extends Fighter implements IFighter {
    private static final String VETERAN = "Veteran";

    // 30% of initial
    private final int veteranLimitHitPoints = PERCENTAGE_LIM_WHEN_BERSERK * HIGHLANDER_INIT_HP / 100;

    // counter for the great sword
    private int nbTimesUsed;

    private boolean veteranMode;

    //to reset damage when becoming berserk
    private boolean berserkDamageDone;

    public Highlander() {
        hitPoints = HIGHLANDER_INIT_HP;
        inflictedDamage = GREAT_SWORD_DAMAGE;
    }

    public Highlander(String detail) {
        this();
        if (detail.equals(VETERAN)) {
            veteranMode = true;
        }
    }

    @Override
    public Highlander equip(String equipment) {
        equipmentList.add(equipment);
        return this;
    }

    private void updateDamage() {
        if (berserkDamageDone) return;

        if (hitPoints < veteranLimitHitPoints) {
            inflictedDamage *= DMG_MULT_WHEN_BERSERK;
            berserkDamageDone = true;
        }
    }

    @Override
    protected void blow(Fighter opponent) {
        if (veteranMode) updateDamage();

        nbTimesUsed++;

        // the great sword works 2 times on 3
        if (nbTimesUsed < 3)
            opponent.reduceHitPoints(inflictedDamage);
        else nbTimesUsed = 0;
    }
}
