package lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        List<Treasure> treasures = new ArrayList<>(Arrays.asList(
                new Treasure(20, 200),
                new Treasure(15, 400),
                new Treasure(5, 50),
                new Treasure(7, 600),
                new Treasure(35, 300),
                new Treasure(12, 700)
                ));

       System.out.println(multiplier(3,5));
       System.out.println(knapsack(50, treasures)); //вносим в первый аргумент максимальную вместимость
    }

    static int multiplier(int number, int power){
        if (power == 0){
            return 1;
        } else{
            return multiplier(number, power - 1) * number;
        }
    }

    static int knapsack(int maxWeight, List<Treasure> treasures){
        Treasure treasure = getMaxValuedItem(maxWeight, treasures);
        if (treasure == null ) {
            return 0;
        } else{
            System.out.println("value added to knapsack: " + treasure.getValue());
            return knapsack(maxWeight - treasure.getWeight(), treasures) + treasure.getWeight();
        }
    }

    private static Treasure getMaxValuedItem(int maxWeight, List<Treasure> treasures) {
        Treasure intermediateTreasure = null; //берем по дефолту первый элемент
        Iterator<Treasure> iter = treasures.iterator();
        while (iter.hasNext()){ //ищем первый попавшийся элемент в принципе влезающий в рюкзак для дальнейшего сравнения
            Treasure currentTreasure = iter.next();
            if (currentTreasure.getWeight() <= maxWeight) {
                intermediateTreasure = currentTreasure;
                break;
            }
        }
        if (intermediateTreasure == null) return null; // если ни один предмет не влезает в рюкзак, возвращаем null
        Iterator<Treasure> iter2 = treasures.iterator();
        while (iter2.hasNext()){ // теперь ищем среди остальных элементов, влезающих в рюкзак, элемент с максимальной ценностью
            Treasure treasure = iter2.next();
            if (treasure.getValue() > intermediateTreasure.getValue() && treasure.getWeight()<=maxWeight){
                intermediateTreasure = treasure;
            }
        }
        treasures.remove(intermediateTreasure); // и удаляем этот элемент из коллекции, чтобы больше его не учитывать.
        return intermediateTreasure;
    }
}
