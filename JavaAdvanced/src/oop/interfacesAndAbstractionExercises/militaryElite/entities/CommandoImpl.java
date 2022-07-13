package oop.interfacesAndAbstractionExercises.militaryElite.entities;

import oop.interfacesAndAbstractionExercises.militaryElite.enums.Corps;
import oop.interfacesAndAbstractionExercises.militaryElite.interfaces.Commando;
import oop.interfacesAndAbstractionExercises.militaryElite.interfaces.Mission;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private final List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return Collections.unmodifiableCollection(this.missions);
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                "Missions:" + (this.missions.isEmpty() ? "" : System.lineSeparator() +
                this.missions.stream()
                        .map(m -> "  " + m.toString())
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}