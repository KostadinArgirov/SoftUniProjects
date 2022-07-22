package oop.reflectionExercises.barracksWarsTheCommandsStrikeBack.core.commands;

import oop.reflectionExercises.barracksWarsTheCommandsStrikeBack.interfaces.Repository;
import oop.reflectionExercises.barracksWarsTheCommandsStrikeBack.interfaces.Unit;
import oop.reflectionExercises.barracksWarsTheCommandsStrikeBack.interfaces.UnitFactory;

public class Add extends Command{
    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.getUnitFactory().createUnit(unitType);
        this.getRepository().addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}