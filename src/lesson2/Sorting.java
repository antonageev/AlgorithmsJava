package lesson2;

import javax.crypto.spec.PSource;
import java.util.Arrays;

public class Sorting {
//    static int[] array1 = new int[]{5, 10, 15, 3, 8, 47, -19};

    public static void main(String[] args) {
        //тест работоспособности методов сортировки на маленьких массивах
        System.out.println("сортировка массивов 3 шт.");
        int[] array1 = new int[]{5, 10, 15, 3, 8, 47, -19};
        printArr(bubbleSortArray(array1));
        System.out.println();
        int[] array2 = new int[]{0, 120, 5, 4, 3, 8, 47, -7, 18};
        printArr(markerSortArray(array2));
        System.out.println();
        int[] array3 = new int[]{5, 6, 1, 2, 7, 15, 9, -12, 36};
        printArr(insertSortArray(array3));

        System.out.println();

        System.out.println("Начальный массив:");
        printArr(array1);
        System.out.println();
        System.out.println("удаляем из массива первый элемент со значением 15");
        printArr(deleteFirstEntryFromArr(array1, 15));

        System.out.println();

        System.out.println("Начальный массив:");
        printArr(array2);
        System.out.println();
        System.out.println("находим индекс элемента со значением 47");
        System.out.println(findElementIndexFromArray(array2, 47));

        System.out.println("Начальный массив:");
        printArr(array3);
        System.out.println();
        System.out.println("вставляем в массив элемент со значением 130 в индекс 3");
        printArr(insertElementIntoArray(array3, 130, 3));

        System.out.println();
// улитка: громоздкий алгоритм, зато работает с любой размерностью и в любом порядке.
        System.out.println("крутим улитку:");
        printArr(snail(7,13));

        int[] arrMillion = new int[100_000];
        for (int i = 0; i < arrMillion.length; i++) {
            arrMillion[i] = (int) Math.round(Math.random()*1000);
        }

// сортировки ниже ( 3 шт.) нужно открывать по одной:

//        сортировка пузырьком (100 тыс записей сортирует 16 секунд, миллион - вечность)
//        long a = System.currentTimeMillis();
//        bubbleSortArray(arrMillion);
//        System.out.print("Сортировка пузырьком занимает: ");
//        System.out.println(System.currentTimeMillis()-a);

//        сортировка маркером (100 тыс записей сортирует 4 секунды, миллион ждать очень долго)
//        long a = System.currentTimeMillis();
//        markerSortArray(arrMillion);
//        System.out.print("Сортировка маркером занимает: ");
//        System.out.println(System.currentTimeMillis()-a);

//        сортировка вставкой (1 миллион записей у меня на компе сортирует 83 секунды - и это самая быстрая сортировка)
//        long a = System.currentTimeMillis();
//        insertSortArray(arrMillion);
//        System.out.print("Сортировка вставкой занимает: ");
//        System.out.println(System.currentTimeMillis()-a);
    }

    public static int[] deleteFirstEntryFromArr(int[] arr, int element){
        int index = -1;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i] == element){
                index = i;
                break;
            }
        }

        if (index == -1) return arr;

        for (int i = index; i <arr.length-1 ; i++) {
            arr[i] = arr[i+1];
        }
        int[] resultArr = Arrays.copyOfRange(arr, 0, arr.length-1);
        return resultArr;
    }

    public static int findElementIndexFromArray(int[] arr, int element){
        for (int index = 0; index <arr.length ; index++) {
            if (arr[index] == element){
                return index;
            }
        }
        return -1;
    }

    public static int[] insertElementIntoArray(int[] arr, int element, int index){
        if (index > arr.length - 1 || index < 0 ) return arr;

        int[] resultArr = new int[arr.length + 1];

        for (int i = 0; i < arr.length + 1 ; i++) {
            if (i < index){
                resultArr[i] = arr[i];
            } else if (i == index) {
                resultArr[i] = element;
            } else {
                resultArr[i] = arr[i-1];
            }
        }
        return resultArr;
    }

    public static int[] bubbleSortArray(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++){
                if (arr[j] > arr[j + 1]) {
                    int buffer = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buffer;
                }
            }
        }
        return arr;
    }

    public static int[] markerSortArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int mark = i;
            for (int j = i + 1; j< arr.length; j++){
                if (arr[j] < arr[mark]){
                    mark = j;
                }
            }
            int buffer = arr[i];
            arr[i] = arr[mark];
            arr[mark] = buffer;
        }
        return arr;
    }

    public static int[] insertSortArray(int[] arr){
        for (int i = 1; i <arr.length ; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j-1] >= temp){
                arr[j] = arr[j - 1];
                --j;
            }
            arr[j] = temp;
        }
        return arr;
    }

    public static void printArr(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void printArr(int[][] arr){
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

// Наверное, не самый изящный алгоритм, зато работает с любой размерностью.
    static int[][] snail(int iLength, int jLength) {
        int counter = 0;
        int[][] resultArr = new int[iLength][jLength];
        int i=0;
        int j=0;
        int elem = 0;
        int minLength = iLength < jLength ? iLength : jLength;
        while (counter < minLength / 2 ){
            i = 0 + counter;
            for (j = 0 + counter; j < jLength - counter; j++){
                resultArr[i][j] = elem++;
            }
            //***
            j = jLength - counter - 1;
            for (i = 1 + counter; i < iLength - counter; i++){
                resultArr[i][j] = elem++;
            }
            //***
            i = iLength - 1 - counter;
            for (j = jLength - 2 - counter; j >= 0 + counter; j--){
                resultArr[i][j] = elem++;
            }
            //***
            j = 0 + counter;
            for (i = iLength - 2 - counter; i >= 1 + counter; i--){
                resultArr[i][j] = elem++;
            }
            counter++;
        }
        if (minLength % 2 == 1 && iLength < jLength){
            i = 0 + counter;
            for (j = 0 + counter; j < jLength - counter; j++){
                resultArr[i][j] = elem++;
            }
        }
        if (minLength % 2 == 1 && jLength < iLength){
            i = 0 + counter;
            for (j = 0 + counter; j < jLength - counter; j++){
                resultArr[i][j] = elem++;
            }
            j = jLength - counter - 1;
            for (i = 1 + counter; i < iLength - counter; i++){
                resultArr[i][j] = elem++;
            }
        }
        return resultArr;
    }
}
