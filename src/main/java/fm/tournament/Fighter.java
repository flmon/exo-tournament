package fm.tournament;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fmonachon
 * <p>
 * This class is to define the common fields of a fighter
 */
public abstract class Fighter implements IFighter {

    private static final String BUCKLER = "buckler";
    public static final String AXE = "axe";
    private static final String ARMOR = "armor";

    public static final int SWORD_DAMAGE = 5;

    // the current points of the fighter
    protected int hitPoints;

    // fighter's weapons
    protected List<String> equipmentList = new ArrayList<>();

    // the damages inflicted
    protected int inflictedDamage;

    //if we have a buckler, tell if it will block
    private boolean bucklerIsOn;

    //if opponent has an axe
    private boolean opponentHasAxe;

    //counter to see if buckler is OK
    private int nbHitsReceived;

    public int hitPoints() {
        return Math.max(0, hitPoints);
    }

    // the fighting
    public void engage(IFighter opponent) {

        checkEquipment(this, opponent);
        while (hitPoints > 0 && opponent.hitPoints() > 0) {

            // 1st blow
            blow(opponent);

            ((Fighter) opponent).blow(this);
        }
    }

    private void checkEquipment(IFighter fighter1, IFighter fighter2) {
        fighter1.checkEquipment(fighter2);
        fighter2.checkEquipment(fighter1);
    }

    public void checkEquipment(IFighter opponent) {
        if (equipmentList.contains(BUCKLER)) bucklerIsOn = true;
        if (equipmentList.contains(ARMOR)) inflictedDamage--;
        if (((Fighter) opponent).hasAnAxe()) opponentHasAxe = true;
    }

    //a single attack
    public void blow(IFighter opponent) {
        opponent.reduceHitPoints(inflictedDamage);
    }

    public void reduceHitPoints(int amount) {
        int effectiveDamage = amount;
        if (equipmentList.contains(ARMOR)) effectiveDamage -= 3;

        if (bucklerIsOn) bucklerIsOn = false;
        else {
            hitPoints -= effectiveDamage;
            nbHitsReceived++;

            if (equipmentList.contains(BUCKLER))
                if (!opponentHasAxe || nbHitsReceived <= 3)
                    bucklerIsOn = true;
        }
    }

    private boolean hasAnAxe() {
        return equipmentList.contains(AXE);
    }
}
