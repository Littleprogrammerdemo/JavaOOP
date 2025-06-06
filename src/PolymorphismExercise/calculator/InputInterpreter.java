package PolymorphismExercise.calculator;

import PolymorphismExercise.calculator.CalculationEngine;
import PolymorphismExercise.calculator.DivisionOperation;

public class InputInterpreter {
    private CalculationEngine engine;

    public InputInterpreter(CalculationEngine engine){
        this.engine = engine;
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        }catch (Exception ex){
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }

    public Operation getOperation(String operation) {
        switch (operation) {
            case "*":
                return new MultiplicationOperation();
            case "/":
                return new DivisionOperation();
            case "ms":
                return new MemorySaveOperation();
            case "mr":
                return new MemoryRecallOperation();
            default:
                return null;
        }
    }
}