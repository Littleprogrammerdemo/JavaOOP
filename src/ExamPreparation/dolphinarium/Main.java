package ExamPreparation.dolphinarium;

import ExamPreparation.dolphinarium.core.Engine;
import ExamPreparation.dolphinarium.core.EngineImpl;
import ExamPreparation.dolphinarium.entities.pools.Pool;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();

    }
}