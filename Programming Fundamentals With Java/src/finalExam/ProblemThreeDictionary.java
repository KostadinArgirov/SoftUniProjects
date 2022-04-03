package finalExam;

import java.util.*;

public class ProblemThreeDictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> dictionary = new LinkedHashMap<>();

        String line = scanner.nextLine();

        String[] input = line.split("\\s+\\|\\s+");

        for(String wordAndDef : input) {

            String[] definitions = wordAndDef.split("\\s*:\\s*");
            dictionary.putIfAbsent(definitions[0], new ArrayList<>());

            for (int i = 1; i < definitions.length; i++) {
                dictionary.get(definitions[0]).add(definitions[i]);
            }
        }
        String[] print = scanner.nextLine().split("\\s*\\|\\s*");

        String command = scanner.nextLine();
        if("Test".equals(command)) {
            for (String printWordDef : print) {
                if (dictionary.containsKey(printWordDef)) {
                    System.out.println(printWordDef + ":");
                    dictionary.get(printWordDef)
                            .forEach(e -> System.out.println(String.format(" -%s", e)));
                }
            }
        } else if ("Hand Over".equals(command)) {
            dictionary.forEach((key, value) -> System.out.print(String.format("%s ", key)));
        }
    }
}