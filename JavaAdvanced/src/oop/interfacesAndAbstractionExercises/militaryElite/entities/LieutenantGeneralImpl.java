package oop.interfacesAndAbstractionExercises.militaryElite.entities;

import oop.interfacesAndAbstractionExercises.militaryElite.interfaces.LieutenantGeneral;
import oop.interfacesAndAbstractionExercises.militaryElite.interfaces.Private;
import oop.interfacesAndAbstractionExercises.militaryElite.interfaces.Soldier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private final List<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    public List<Private> getPrivates() {
        return Collections.unmodifiableList(privates);
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + "Privates:" + (this.privates.isEmpty() ? "" :
                System.lineSeparator()
                        + this.privates.stream()
                        .sorted(Comparator.comparingInt(Soldier::getId).reversed())
                        .map(p -> "  " + p)
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}