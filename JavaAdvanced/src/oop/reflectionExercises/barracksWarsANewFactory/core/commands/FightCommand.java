package oop.reflectionExercises.barracksWarsANewFactory.core.commands;

import oop.reflectionExercises.barracksWarsANewFactory.interfaces.Repository;
import oop.reflectionExercises.barracksWarsANewFactory.interfaces.UnitFactory;

public class FightCommand extends Command {
    public FightCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}