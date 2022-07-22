package oop.reflectionExercises.barracksWarsTheCommandsStrikeBack.core.commands;

import oop.reflectionExercises.barracksWarsTheCommandsStrikeBack.interfaces.Repository;
import oop.reflectionExercises.barracksWarsTheCommandsStrikeBack.interfaces.UnitFactory;

public class Fight extends Command{
    public Fight(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}