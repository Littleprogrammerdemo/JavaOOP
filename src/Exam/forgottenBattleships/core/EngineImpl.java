package Exam.forgottenBattleships.core;

import Exam.forgottenBattleships.common.Command;
import Exam.forgottenBattleships.entities.battlezone.BattleZone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private final Controller controller;
    private final BufferedReader reader;

    public EngineImpl() {
        this.controller = new ControllerImpl();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result;
            try {
                result = processInput();

                if (result.equals("Exit")) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IllegalStateException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddBattleZone:
                result = addBattleZone(data);
                break;
            case GetBattleZoneByName:
                result = String.valueOf(getBattleZoneByName(data));
                break;
            case AddBattleshipToBattleZone:
                result = addBattleshipToBattleZone(data);
                break;
            case StartBattle:
                result = startBattle(data);
                break;
            case GetStatistics:
                result = getStatistics();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }
        return result;
    }

    private String addBattleZone(String[] data) {
        String battleZoneName = data[0];
        int capacity = Integer.parseInt(data[1]);
        return this.controller.addBattleZone(battleZoneName, capacity);
    }

    private String addBattleshipToBattleZone(String[] data) {
        String battleZoneName = data[0];
        String shipType = data[1];
        String shipName = data[2];
        int health = Integer.parseInt(data[3]);
        return this.controller.addBattleshipToBattleZone(battleZoneName, shipType, shipName, health);
    }

    private BattleZone getBattleZoneByName(String[] data) {
        return this.controller.getBattleZoneByName(data[0]);
    }

    private String startBattle(String[] data) {
        String battleZoneName = data[0];
        String attackingShip = data[1];
        String shipUnderAttack = data[2];
        return this.controller.startBattle(battleZoneName, attackingShip, shipUnderAttack);
    }

    private String getStatistics() {
        return this.controller.getStatistics();
    }
}

    //TODO Implement all the methods below

