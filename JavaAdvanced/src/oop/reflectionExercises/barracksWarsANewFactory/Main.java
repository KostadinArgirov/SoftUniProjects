package oop.reflectionExercises.barracksWarsANewFactory;

import oop.reflectionExercises.barracksWarsANewFactory.data.UnitRepository;
import oop.reflectionExercises.barracksWarsANewFactory.interfaces.Repository;
import oop.reflectionExercises.barracksWarsANewFactory.core.Engine;
import oop.reflectionExercises.barracksWarsANewFactory.core.factories.UnitFactoryImpl;
import oop.reflectionExercises.barracksWarsANewFactory.interfaces.Runnable;
import oop.reflectionExercises.barracksWarsANewFactory.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}