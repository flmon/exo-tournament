package fm.tournament;

/**
 * @author Florian Monachon
 * <p>
 * This class is to define a specialized fighter
 */
public class Viking extends Fighter implements IFighter {

    public Viking() {
        hitPoints = VIKING_INIT_HP;
        inflictedDamage = SWORD_DAMAGE;
        equip(AXE);
    }

    @Override
    public Viking equip(String equipment) {
        equipmentList.add(equipment);

        //he has axe correct damage
        if (equipment.equals(AXE)) inflictedDamage += AXE_DAMAGE - SWORD_DAMAGE;
        return this;
    }
}
