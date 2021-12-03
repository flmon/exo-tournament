package fm.tournament;

/**
 * @author Florian Monachon
 * <p>
 * This interface defines minimal methods to implement
 */
public interface IFighter {

    //this engage opponent means that this will give the first blow, then opponent will respond
    void engage(IFighter opponent);

    //the current number of points of the fighter
    int hitPoints();

    //to add some equipment
    IFighter equip(String equipment);
}
