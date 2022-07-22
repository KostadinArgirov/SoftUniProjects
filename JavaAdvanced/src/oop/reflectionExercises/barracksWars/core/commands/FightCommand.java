package oop.reflectionExercises.barracksWars.core.commands;

import oop.reflectionExercises.barracksWars.interfaces.Repository;
import oop.reflectionExercises.barracksWars.interfaces.UnitFactory;

public class FightCommand extends Command {
    public FightCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}