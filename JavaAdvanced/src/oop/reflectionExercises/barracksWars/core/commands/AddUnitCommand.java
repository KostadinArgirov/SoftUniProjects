package oop.reflectionExercises.barracksWars.core.commands;

import oop.reflectionExercises.barracksWars.interfaces.Repository;
import oop.reflectionExercises.barracksWars.interfaces.Unit;
import oop.reflectionExercises.barracksWars.interfaces.UnitFactory;

public class AddUnitCommand extends Command {
    public AddUnitCommand(String[] data, Repository repository, UnitFactory unitFactory) {
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