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

    // the current points of the fighter
    protected int hitPoints;

    // fighter's weapons
    protected List<String> equipmentList = new ArrayList<>();

    // the damages inflicted
    protected int inflictedDamage;

    //if we have a buckler, tell if it will block
    private boolean bucklerIsOn;

    //if opponent has an axe
    private boolean oppponentHasAxe;

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

            opponent.blow(this);
        }
    }

    private void checkEquipment(IFighter fighter1, IFighter fighter2) {
        fighter1.checkEquipment(fighter2);
        fighter2.checkEquipment(fighter1);
    }

    public void checkEquipment(IFighter opponent) {
        if (equipmentList.contains(BUCKLER)) bucklerIsOn = true;
        if (opponent.hasAnAxe()) oppponentHasAxe = true;
    }

    public void blow(IFighter opponent) {
        opponent.reduceHitPoints(inflictedDamage);
    }

    public void reduceHitPoints(int amount) {
        if (bucklerIsOn) bucklerIsOn = false;
        else {
            hitPoints -= amount;
            nbHitsReceived++;

            if (equipmentList.contains(BUCKLER))
                if (!oppponentHasAxe || nbHitsReceived <= 3)
                    bucklerIsOn = true;
        }
    }

    public boolean hasAnAxe() {
        return equipmentList.contains(AXE);
    }
}
