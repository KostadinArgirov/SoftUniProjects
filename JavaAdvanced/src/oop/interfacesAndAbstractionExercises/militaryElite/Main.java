package oop.interfacesAndAbstractionExercises.militaryElite;

import oop.interfacesAndAbstractionExercises.militaryElite.entities.*;
import oop.interfacesAndAbstractionExercises.militaryElite.enums.Corps;
import oop.interfacesAndAbstractionExercises.militaryElite.enums.State;
import oop.interfacesAndAbstractionExercises.militaryElite.interfaces.Private;
import oop.interfacesAndAbstractionExercises.militaryElite.interfaces.Soldier;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static Map<Integer, Private> privatesById = new LinkedHashMap<>();
    private static List<Soldier> soldiers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        while (!"End".equals(tokens[0])) {

            Soldier soldier = createSoldier(tokens, privatesById);

            if (soldier != null) {
                soldiers.add(soldier);
                if (soldier instanceof Private) {
                    privatesById.put(soldier.getId(), (Private) soldier);
                }
            }

            tokens = scanner.nextLine().split("\\s+");
        }


        System.out.print(soldiers.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private static Soldier createSoldier(String[] tokens, Map<Integer, Private> privates) {
        String solderType = tokens[0];
        int id = Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];

        switch (solderType) {
            case "Private":
                double salary = Double.parseDouble(tokens[4]);
                return new PrivateImpl(id, firstName, lastName, salary);
            case "LieutenantGeneral":
                return createOfficer(tokens);
            case "Engineer":
                return createEngineer(tokens);
            case "Commando":
                return createCommando(tokens);
            case "Spy":
                String codeNumber = tokens[4];
                return new SpyImpl(id, firstName, lastName, codeNumber);
            default:
                return null;
        }
    }

    private static Private createEngineer(String[] tokens) {
        int id = Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        double salary = Double.parseDouble(tokens[4]);
        EngineerImpl engineer = null;

        if (Corps.isValidCorps(tokens[5])) {
            Corps corps = Corps.valueOf(tokens[5].toUpperCase());

            engineer = new EngineerImpl(id, firstName, lastName, salary, corps);

            for (int i = 6; i < tokens.length; i += 2) {
                engineer.addRepair(new RepairImpl(tokens[i], Integer.parseInt(tokens[i + 1])));
            }
        }

        return engineer;
    }

    private static Private createCommando(String[] tokens) {
        int id = Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        double salary = Double.parseDouble(tokens[4]);
        CommandoImpl commando = null;

        if (Corps.isValidCorps(tokens[5])) {
            Corps corps = Corps.valueOf(tokens[5].toUpperCase());
            commando = new CommandoImpl(id, firstName, lastName, salary, corps);
            for (int i = 6; i < tokens.length; i += 2) {
                String codeName = tokens[i];
                if (State.isValidState(tokens[i + 1])) {
                    commando.addMission(new MissionImpl(codeName, State.valueOf(tokens[i + 1].toUpperCase())));
                }
            }
        }

        return commando;
    }

    private static Private createOfficer(String[] tokens) {
        int id = Integer.parseInt(tokens[1]);
        String firstName = tokens[2];
        String lastName = tokens[3];
        double salary = Double.parseDouble(tokens[4]);

        LieutenantGeneralImpl officer = new LieutenantGeneralImpl(id, firstName, lastName, salary);

        for (int i = 5; i < tokens.length; i++) {
            Private priv = privatesById.get(Integer.parseInt(tokens[i]));
            officer.addPrivate(priv);
        }
        return officer;
    }
}