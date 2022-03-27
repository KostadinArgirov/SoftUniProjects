package mapsLambdaAndStreamAPIExercise;

import java.util.*;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, List<String>> companies = new LinkedHashMap<>();

        while (!line.equals("End")) {
            String[] data = line.split(" -> ");
            String companyName = data[0];
            String employeeId = data[1];

            if (!companies.containsKey(companyName)) {
                companies.put(companyName, new ArrayList<>());
            }
            if (companies.containsKey(companyName) && !companies.get(companyName).contains(employeeId)) {
                companies.get(companyName).add(employeeId);
            }

            line = scanner.nextLine();
        }
        for (var entry : companies.entrySet()) {
            System.out.println(entry.getKey());
            for (String ids : entry.getValue()) {
                System.out.println("-- "+ ids);
            }
        }
    }
}
