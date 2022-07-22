package oop.reflectionExercises.barracksWarsTheCommandsStrikeBack;

import oop.reflectionExercises.barracksWarsTheCommandsStrikeBack.interfaces.Repository;
import oop.reflectionExercises.barracksWarsTheCommandsStrikeBack.interfaces.Runnable;
import oop.reflectionExercises.barracksWarsTheCommandsStrikeBack.interfaces.UnitFactory;
import oop.reflectionExercises.barracksWarsTheCommandsStrikeBack.core.Engine;
import oop.reflectionExercises.barracksWarsTheCommandsStrikeBack.core.factories.UnitFactoryImpl;
import oop.reflectionExercises.barracksWarsTheCommandsStrikeBack.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}