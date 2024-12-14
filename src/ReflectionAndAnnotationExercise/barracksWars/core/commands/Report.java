package ReflectionAndAnnotationExercise.barracksWars.core.commands;

import ReflectionAndAnnotationExercise.barracksWars.interfaces.Repository;

public class Report extends Command{

    @Inject
    private Repository repository;

    private Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}