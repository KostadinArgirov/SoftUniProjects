package oop.reflectionExercises.barracksWars;

import oop.reflectionExercises.barracksWars.data.UnitRepository;
import oop.reflectionExercises.barracksWars.interfaces.Repository;
import oop.reflectionExercises.barracksWars.core.Engine;
import oop.reflectionExercises.barracksWars.core.factories.UnitFactoryImpl;
import oop.reflectionExercises.barracksWars.interfaces.Runnable;
import oop.reflectionExercises.barracksWars.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}