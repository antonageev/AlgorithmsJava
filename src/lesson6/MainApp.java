package lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        //тест дерева
        MyTreeMap<Integer, String> myTreeMap= new MyTreeMap<>();
        myTreeMap.put(5, "five");
        myTreeMap.put(4, "four");
        myTreeMap.put(2, "two");
        myTreeMap.put(1, "one");
        myTreeMap.put(-1, "minus one");
        myTreeMap.put(8, "eight");

        System.out.println(myTreeMap);

        myTreeMap.put(4, "veryFour");
        System.out.println(myTreeMap.get(4));
        myTreeMap.delete(5); // при удалении root (в данном случае 5) код из вебинара не работает, пришлось дорабатывать метод delete.
        System.out.println();
        System.out.println(myTreeMap);
        System.out.println("Тест 20 деревьев с рандомными значениями до 6 уровня");

        //Задание 1
        List<MyTreeMap<Integer, Integer>> list = new ArrayList<>();
        Random number = new Random();
        for (int i = 0; i < 20; i++){
            MyTreeMap<Integer, Integer> map = new MyTreeMap<>();
            while (map.countLevels() < 6){
                map.put(number.nextInt(200) - 100, number.nextInt());
            }
            list.add(map);
        }

        // чем ближе к 0 первый сгенерированный элемент (root), тем больше вероятность, что дерево будет сбалансированным
        // при условии случайных ключей в диапазоне [-100 +100]
        // 20 - 25% деревьев получаются сбалансированными.

        for (int i = 0; i < list.size(); i++){
            System.out.println("дерево № " + (i + 1));
            System.out.println(list.get(i).printRootValues());;
            System.out.println(list.get(i));
        }
    }
}
