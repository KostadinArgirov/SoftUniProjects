package oop.reflectionExercises.barracksWars.core.commands;

import oop.reflectionExercises.barracksWars.interfaces.Repository;
import oop.reflectionExercises.barracksWars.interfaces.Executable;
import oop.reflectionExercises.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {
    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    public Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected Repository getRepository() {
        return repository;
    }

    protected UnitFactory getUnitFactory() {
        return unitFactory;
    }

    protected String[] getData() {
        return data;
    }
}