package ReflectionAndAnnotationExercise.barracksWars;

import ReflectionAndAnnotationExercise.barracksWars.interfaces.Repository;
import ReflectionAndAnnotationExercise.barracksWars.interfaces.Runnable;
import ReflectionAndAnnotationExercise.barracksWars.interfaces.UnitFactory;
import ReflectionAndAnnotationExercise.barracksWars.core.Engine;
import ReflectionAndAnnotationExercise.barracksWars.core.factories.UnitFactoryImpl;
import ReflectionAndAnnotationExercise.barracksWars.data.UnitRepository;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}