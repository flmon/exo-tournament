package fm.tournament;

public class Swordsman extends Fighter implements IFighter {
    private static final String VICIOUS = "Vicious";

    private boolean viciousMode;

    // counter for the poison
    private int nbTimesUsed;

    public Swordsman() {
        hitPoints = 100;
        inflictedDamage = SWORD_DAMAGE;
    }

    public Swordsman(String detail) {
        this();
        if (detail.equals(VICIOUS)) {
            viciousMode = true;
        }
    }

    public Swordsman equip(String equipment) {
        equipmentList.add(equipment);

        //the axe increase dmg of 1
        if (equipment.equals(AXE)) inflictedDamage++;
        return this;
    }

    private void updateDamage() {
        nbTimesUsed++;
        if (nbTimesUsed > 3) return;
        if (nbTimesUsed == 1) inflictedDamage += 20;
        if (nbTimesUsed == 3) inflictedDamage -= 20;
    }

    public void blow(IFighter opponent) {
        if (viciousMode) updateDamage();

        opponent.reduceHitPoints(inflictedDamage);
    }
}
