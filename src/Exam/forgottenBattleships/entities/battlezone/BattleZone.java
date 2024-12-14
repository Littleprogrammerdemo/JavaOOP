package Exam.forgottenBattleships.entities.battlezone;

import Exam.forgottenBattleships.entities.battleship.Battleship;

import java.util.Collection;

public interface BattleZone {

    String getName();

    int getCapacity();

    void addBattleship(Battleship ship);

    Battleship getBattleshipByName(String battleshipName);

    void removeBattleShip(Battleship ship);

    Collection<Battleship> getShips();


}
