package fm.tournament;

public interface IFighter {

    void engage(IFighter opponent);

    int hitPoints();

    IFighter equip(String equipment);

    //a single attack
    void blow(IFighter opponent);

    //
    void reduceHitPoints(int amount);

    //
    void checkEquipment(IFighter opponent);

    boolean hasAnAxe();
}
