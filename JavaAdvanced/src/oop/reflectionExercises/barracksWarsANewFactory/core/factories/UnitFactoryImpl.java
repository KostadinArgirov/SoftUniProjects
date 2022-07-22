package oop.reflectionExercises.barracksWarsANewFactory.core.factories;

import oop.reflectionExercises.barracksWarsANewFactory.interfaces.Unit;
import oop.reflectionExercises.barracksWarsANewFactory.interfaces.UnitFactory;

import java.lang.reflect.Constructor;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"oop.reflectionExercises.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		try{
			Class clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor ctor = clazz.getConstructor();
			return (Unit)ctor.newInstance();
		}catch (Exception ex){
			ex.printStackTrace();
		}

		return null;
	}
}