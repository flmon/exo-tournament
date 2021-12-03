package fm.tournament;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fmonachon
 * <p>
 * Codes in this package is to implement tournament test
 * <p>
 * This class is to define the common fields of a fighter
 */
public abstract class Fighter implements IFighter {

    // the current points of the fighter
    protected int hitPoints;

    // fighter's weapons
    protected List<String> equipmentList = new ArrayList<>();

    // the damages inflicted
    protected int inflictedDamage;

    public int hitPoints() {
        if (hitPoints < 0) return 0;
        else
            return hitPoints;
    }

    // the fighting
    public void engage(IFighter opponent) {

        while (hitPoints > 0 && opponent.hitPoints() > 0) {

            // 1st blow
            blow(opponent);

            opponent.blow(this);
        }
    }

    public void blow(IFighter opponent) {
        opponent.reduceHitPoints(inflictedDamage);
    }

    public void reduceHitPoints(int amount) {
        hitPoints -= amount;
    }
}
