package Exam.forgottenBattleships.entities.battlezone;

import Exam.forgottenBattleships.entities.battleship.Battleship;
import Exam.forgottenBattleships.common.ExceptionMessages;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class BattleZoneImpl implements BattleZone {
    private String name;
    private int capacity;
    private Map<String, Battleship> ships;

    public BattleZoneImpl(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.ships = new LinkedHashMap<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.BATTLE_ZONE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public void addBattleship(Battleship ship) {
        if (this.ships.size() >= this.capacity) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
        }
        if (ship.getHealth() <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.SHIP_HEALTH_NULL_OR_EMPTY);
        }
        if (this.ships.containsKey(ship.getName())) {
            throw new IllegalArgumentException(ExceptionMessages.SHIP_EXISTS);
        }
        this.ships.put(ship.getName(), ship);
    }

    @Override
    public Battleship getBattleshipByName(String battleshipName) {
        return this.ships.get(battleshipName);
    }

    @Override
    public void removeBattleShip(Battleship ship) {
        this.ships.remove(ship.getName());
    }

    @Override
    public Collection<Battleship> getShips() {
        return this.ships.values();
    }
}