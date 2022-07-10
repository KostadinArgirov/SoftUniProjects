package oop.inheritanceLab.randomArrayList;

public class Main {
    public static void main(String[] args) {

        RandomArrayList list = new RandomArrayList();

        list.add(412);
        list.add(6);
        list.add(52);
        list.add(802);

        System.out.println(list.getRandomElement());
    }
}
