package ReflectionAndAnnotationExercise.barracksWars.core.commands;

import ReflectionAndAnnotationExercise.barracksWars.interfaces.Repository;
import ReflectionAndAnnotationExercise.barracksWars.interfaces.Unit;
import ReflectionAndAnnotationExercise.barracksWars.interfaces.UnitFactory;

public class Add extends Command {

    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    protected Add(String[] data) {
        super(data);
    }



    @Override
    public String execute() {
        String unitType = super.getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}