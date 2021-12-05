package fm.tournament;

/**
 * @author Florian Monachon
 * <p>
 * This class is to define a specialized fighter
 */
public class Swordsman extends Fighter implements IFighter {
    private static final String VICIOUS = "Vicious";

    private boolean viciousMode;

    // counter for the poison
    private int nbTimesUsed;

    public Swordsman() {
        hitPoints = SWORDSMAN_INIT_HP;
        inflictedDamage = SWORD_DAMAGE;
    }

    public Swordsman(String detail) {
        this();
        if (detail.equals(VICIOUS)) {
            viciousMode = true;
        }
    }

    @Override
    public Swordsman equip(String equipment) {
        equipmentList.add(equipment);

        //if he has axe correct damage
        if (equipment.equals(AXE)) inflictedDamage += AXE_DAMAGE - SWORD_DAMAGE;
        return this;
    }

    private void updateDamage() {
        nbTimesUsed++;
        if (nbTimesUsed > POISON_MAX_USE + 1) return;
        if (nbTimesUsed == 1) inflictedDamage += DMG_INFL_INC_WHEN_POISON;
        if (nbTimesUsed == POISON_MAX_USE + 1) inflictedDamage -= DMG_INFL_INC_WHEN_POISON;
    }

    @Override
    protected void blow(Fighter opponent) {
        if (viciousMode) updateDamage();

        opponent.reduceHitPoints(inflictedDamage);
    }
}
