package Exam.forgottenBattleships.core;

import Exam.forgottenBattleships.common.ConstantMessages;
import Exam.forgottenBattleships.common.ExceptionMessages;
import Exam.forgottenBattleships.entities.battlezone.BattleZone;
import Exam.forgottenBattleships.entities.battlezone.BattleZoneImpl;
import Exam.forgottenBattleships.entities.battleship.Battleship;
import Exam.forgottenBattleships.entities.battleship.PirateBattleship;
import Exam.forgottenBattleships.entities.battleship.RoyalBattleship;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Map<String, BattleZone> battleZones;

    public ControllerImpl() {
        this.battleZones = new LinkedHashMap<>();
    }

    @Override
    public String addBattleZone(String battleZoneName, int capacity) {
        if (this.battleZones.containsKey(battleZoneName)) {
            throw new IllegalArgumentException(ExceptionMessages.BATTLE_ZONE_EXISTS);
        }
        BattleZone battleZone = new BattleZoneImpl(battleZoneName, capacity);
        this.battleZones.put(battleZoneName, battleZone);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BATTLE_ZONE, battleZoneName);
    }

    @Override
    public BattleZone getBattleZoneByName(String battleZoneName) {
        BattleZone battleZone = this.battleZones.get(battleZoneName);
        if (battleZone == null) {
            throw new NullPointerException(ExceptionMessages.BATTLE_ZONE_DOES_NOT_EXISTS);
        }
        return battleZone;
    }

    @Override
    public String addBattleshipToBattleZone(String battleZoneName, String shipType, String shipName, int health) {
        BattleZone battleZone = getBattleZoneByName(battleZoneName);

        Battleship battleship;
        switch (shipType) {
            case "RoyalBattleship":
                battleship = new RoyalBattleship(shipName, health);
                break;
            case "PirateBattleship":
                battleship = new PirateBattleship(shipName, health);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_SHIP_TYPE);
        }

        battleZone.addBattleship(battleship);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SHIP, shipType, shipName, battleZoneName);
    }

    @Override
    public String startBattle(String battleZoneName, String attackingShipName, String shipUnderAttackName) {
        BattleZone battleZone = getBattleZoneByName(battleZoneName);
        Battleship attacker = battleZone.getBattleshipByName(attackingShipName);
        Battleship defender = battleZone.getBattleshipByName(shipUnderAttackName);

        if (attacker == null || defender == null) {
            throw new IllegalArgumentException(ExceptionMessages.INSUFFICIENT_COUNT);
        }

        attacker.attack(defender);
        if (defender.getHealth() <= 0) {
            battleZone.removeBattleShip(defender);
        }

        String remainingShips = battleZone.getShips().stream()
                .map(Battleship::getName)
                .collect(Collectors.joining(", "));
        return String.format(ConstantMessages.BATTLE_CONTINUES, battleZoneName) + remainingShips;
    }

    @Override
    public String getStatistics() {
        StringBuilder stats = new StringBuilder();

        for (BattleZone battleZone : this.battleZones.values()) {
            stats.append(String.format(ConstantMessages.SHIPS_IN_BATTLE_ZONE, battleZone.getName()))
                    .append(System.lineSeparator());

            Collection<Battleship> ships = battleZone.getShips();
            if (ships.size() > 1) {
                ships.forEach(ship -> stats.append(String.format(ConstantMessages.SHIP_INFO, ship.getName(), ship.getHealth(), ship.getAmmunition()))
                        .append(System.lineSeparator()));
            } else {
                stats.append(String.format(ConstantMessages.SHIP_WINS, ships.iterator().next().getName()))
                        .append(System.lineSeparator());
            }
        }

        return stats.toString().trim();
    }
}