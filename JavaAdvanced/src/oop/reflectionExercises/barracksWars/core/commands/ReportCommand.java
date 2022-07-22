package oop.reflectionExercises.barracksWars.core.commands;

import oop.reflectionExercises.barracksWars.interfaces.Repository;
import oop.reflectionExercises.barracksWars.interfaces.UnitFactory;

public class ReportCommand extends Command {
    public ReportCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String output = this.getRepository().getStatistics();
        return output;
    }
}