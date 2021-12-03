package fm.tournament;

/**
 * @author Florian Monachon
 * <p>
 * This class is to define a specialized fighter
 */
public class Viking extends Fighter implements IFighter {

    public Viking() {
        hitPoints = 120;
        inflictedDamage = SWORD_DAMAGE;
        equip(AXE);
    }

    @Override
    public Viking equip(String equipment) {
        equipmentList.add(equipment);

        //the axe increase dmg of 1
        if (equipment.equals(AXE)) inflictedDamage++;
        return this;
    }
}
