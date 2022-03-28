package midExamRetake;

import java.util.*;

public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> pieces = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String piece = input[0];
            String composer = input[1];
            String key = input[2];

            pieces.put(piece, new ArrayList<>());
            pieces.get(piece).add(composer);
            pieces.get(piece).add(key);
        }
        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] commands = input.split("\\|");
            String command = commands[0];
            String piece = commands[1];

            switch (command) {
                case "Add":
                    addPiece(pieces, commands, piece);
                    break;
                case "Remove":
                    removePiece(pieces, piece);
                    break;
                case "ChangeKey":
                    changeKey(pieces, commands, piece);
                    break;
            }
            input = scanner.nextLine();
        }
        pieces.entrySet()
                .forEach(kvp -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                        kvp.getKey(), kvp.getValue().get(0), kvp.getValue().get(1)));
    }

    private static void addPiece(Map<String, List<String>> pieces, String[] commands, String piece) {
        String composer = commands[2];
        String key = commands[3];

        if (pieces.containsKey(piece)) {
            System.out.printf("%s is already in the collection!%n", piece);
        } else {
            pieces.put(piece, new ArrayList<>());
            pieces.get(piece).add(composer);
            pieces.get(piece).add(key);
            System.out.printf("%s by %s in %s added to the collection!%n", piece,composer,key);
        }
    }

    private static void removePiece(Map<String, List<String>> pieces, String piece) {
        if (pieces.containsKey(piece)) {
            pieces.remove(piece);
            System.out.printf("Successfully removed %s!%n", piece);
        } else {
            System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
        }
    }

    private static void changeKey(Map<String, List<String>> pieces, String[] commands, String piece) {
        String newKey = commands[2];

        if (pieces.containsKey(piece)) {
            pieces.get(piece).set(1, newKey);
            System.out.printf("Changed the key of %s to %s!%n", piece,newKey);
        } else {
            System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
        }
    }
}