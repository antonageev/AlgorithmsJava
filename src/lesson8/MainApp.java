package lesson8;

public class MainApp {
    public static void main(String[] args) {

        ChainingHashMap<Integer, String> hashMap = new ChainingHashMap<>(6);

        hashMap.put(1, "One");
        hashMap.put(15, "Fifteen");
        hashMap.put(40, "Forty");
        hashMap.put(4, "Four");
        hashMap.put(88, "Eighty eight");
        hashMap.put(135, "One hundred thirty five");
        hashMap.put(23, "Twenty three");
        hashMap.put(11, "Eleven");

        System.out.println(hashMap);

        System.out.println(hashMap.get(135));

        System.out.println(hashMap.delete(88));

        System.out.println(hashMap);

    }
}
