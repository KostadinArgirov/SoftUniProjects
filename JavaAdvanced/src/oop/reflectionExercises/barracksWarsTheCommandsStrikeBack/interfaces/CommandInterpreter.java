package oop.reflectionExercises.barracksWarsTheCommandsStrikeBack.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}