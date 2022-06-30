package advanced.setsAndMapsAdvancedExercises;

import com.sun.source.tree.Tree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, LinkedHashMap<String, Integer>> usersMap = new TreeMap<>();

        while (!input.equals("end")) {

            String[] inputParts = input.split("\\s+");

            String ipParts = inputParts[0];
            String usernameParts = inputParts[2];
            String username = usernameParts.substring(5);
            String ipAddress = ipParts.substring(3);

            if (!usersMap.containsKey(username)) {
                usersMap.put(username, new LinkedHashMap<>());
            }

            if (!usersMap.get(username).containsKey(ipAddress)) {
                usersMap.get(username).put(ipAddress, 1);
            } else {
                int attackCounter = usersMap.get(username).get(ipAddress) + 1;
                usersMap.get(username).put(ipAddress, attackCounter);
            }

            input = scanner.nextLine();
        }
        for (var attacker : usersMap.entrySet()) {
            System.out.printf("%s:%n", attacker.getKey());
            LinkedHashMap<String, Integer> attacks = attacker.getValue();
            StringBuilder sb = new StringBuilder();

            for (var singleIpAttack : attacks.entrySet()) {
                String formattedAttack = String.format("%s => %d, ", singleIpAttack.getKey(), singleIpAttack.getValue());
                sb.append(formattedAttack);
            }
            String finalOutput = sb.substring(0, sb.length() - 2);
            finalOutput = finalOutput + ".";

            System.out.println(finalOutput);
        }
    }
}