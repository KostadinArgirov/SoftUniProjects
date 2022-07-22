package oop.reflectionExercises.barracksWarsANewFactory.core.commands;

import oop.reflectionExercises.barracksWarsANewFactory.interfaces.Repository;
import oop.reflectionExercises.barracksWarsANewFactory.interfaces.Executable;
import oop.reflectionExercises.barracksWarsANewFactory.interfaces.UnitFactory;

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