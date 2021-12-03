package fm.tournament;

public interface IFighter {

    void engage(IFighter opponent);

    int hitPoints();

    IFighter equip(String equipment);

    //
    void reduceHitPoints(int amount);

    //
    void checkEquipment(IFighter opponent);
}
