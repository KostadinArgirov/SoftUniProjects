package oop.interfacesAndAbstractionExercises.militaryElite.entities;

import oop.interfacesAndAbstractionExercises.militaryElite.enums.Corps;
import oop.interfacesAndAbstractionExercises.militaryElite.interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public Corps getCorps() {
        return corps;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                String.format("Corps: %s", this.getCorps().toString());
    }
}