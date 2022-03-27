package mapsLambdaAndStreamAPIMoreExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+->\\s+");

        LinkedHashMap<String, LinkedHashMap<String, Integer>> map = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> map2 = new LinkedHashMap<>();

        while(!input[0].equals("no more time")){
            map.putIfAbsent(input[1], new LinkedHashMap<>());
            map.get(input[1]).putIfAbsent(input[0], 0);
            map.get(input[1]).put(input[0], Math.max(map.get(input[1]).get(input[0]), Integer.parseInt(input[2])));
            input = scanner.nextLine().split("\\s+->\\s+");
        }
        for (Map.Entry<String,LinkedHashMap<String,Integer>> entry: map.entrySet()) {
            for (Map.Entry<String,Integer> entry2:entry.getValue().entrySet()) {
                map2.putIfAbsent(entry2.getKey(), 0);
                map2.put(entry2.getKey(), map2.get(entry2.getKey()) + entry2.getValue());
            }
        }
        String[] finalInput = input;
        int[] num = new int[1];
        map.entrySet().stream().forEach(c->{
            num[0] = 0;
            System.out.printf("%s: %d participants%n", c.getKey(), c.getValue().size());
            c.getValue().entrySet().stream().sorted((s1,s2)->{
                finalInput[0] = s2.getValue().toString();
                if(s2.getValue()>s1.getValue()) return 1;
                else if(s2.getValue()<s1.getValue()) return -1;
                else return s1.getKey().compareTo(s2.getKey());
            }).forEach(s->{
                System.out.printf("%d. %s <::> %d%n", ++num[0], s.getKey(), s.getValue());
            });
        });
        num[0] = 0;
        System.out.println("Individual standings:");
        map2.entrySet().stream().sorted((s1,s2)->
        {
            if(s2.getValue()>s1.getValue()) return 1;
            else if(s2.getValue()<s1.getValue()) return -1;
            else return s1.getKey().compareTo(s2.getKey());
        }).forEach(c-> {
            System.out.printf("%d. %s -> %d%n", ++num[0], c.getKey(), c.getValue());
        });
    }
}