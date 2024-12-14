package Exam.forgottenBattleships;

import Exam.forgottenBattleships.core.Engine;
import Exam.forgottenBattleships.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Engine engine = new EngineImpl();
        engine.run();
    }
}