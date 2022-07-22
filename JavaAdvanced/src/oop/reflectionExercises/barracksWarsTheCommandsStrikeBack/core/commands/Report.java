package oop.reflectionExercises.barracksWarsTheCommandsStrikeBack.core.commands;

import oop.reflectionExercises.barracksWarsTheCommandsStrikeBack.interfaces.Repository;
import oop.reflectionExercises.barracksWarsTheCommandsStrikeBack.interfaces.UnitFactory;

public class Report extends Command {
    public Report(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String output = this.getRepository().getStatistics();
        return output;
    }
}