package DebuggingTechniques.vehicleShop;

import DebuggingTechniques.vehicleShop.core.Engine;
import DebuggingTechniques.vehicleShop.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}