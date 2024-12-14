package ReflectionAndAnnotationExercise.barracksWars.core.commands;

import ReflectionAndAnnotationExercise.barracksWars.interfaces.Executable;

public abstract class Command implements Executable {
    private String[] data;

    protected Command(String[] data) {
        this.data = data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return data;
    }

    public abstract String execute();
}