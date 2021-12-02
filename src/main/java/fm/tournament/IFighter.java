package fm.tournament;

public interface IFighter {

    void engage(IFighter opponent);

    int hitPoints();

    IFighter equip(String equipment);
}
