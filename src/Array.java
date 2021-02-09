//public class Array {
//    private static final int N = 6;
//
//    public static void main (String [] args){
//
//        //variable
//        int [] row = new int [100_000];
//
//        for(int i= 0; i < 100_001; i++){
//            row [i] = (int)(Math.random() * 100_000 * N * 1000);
//            System.out.print(row[i] + ",");
//        }
//    }
//}

//import java.util.Random;

//public class Array {
//    public static void main(String[] args) {
//        int n = 6;
//        int[] array = new int [100_000];
//        Random random = new Random();
//        for (int i = 0; i < array.length;i++){
//
//           int arr[] = random.ints(100_000,0,100_000 * n * 1000).toArray();
//            System.out.print( arr[i] + ", ");
//        }
//
//    }
//}

import java.util.Arrays;
import java.util.Random;

public class Array {
    private static final int N = 6;

    public static void main(String[] args) {
        // массив целых рандомных чисел в диапазоне от 0 до 100000 * N * 1000  +  подсчет чисел в диапазоне от N  до 2*N
        int[] firstArray = new int[100000];
        int k = 0;
        Random random = new Random();
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = random.nextInt(100000 * N * 1000);
            if (firstArray[i] > N && firstArray[i] < N * 2) k++;
        }
        System.out.println("Количество чисел в диапазоне N - 2*N = " + k);
        //сортировка массива выбором + время
        System.out.println("Сортировка первого массива выбором:");
        chooseSort(firstArray);
        //массив в 2 раза больше
        System.out.println("Массив в 2 раза больше: ");
        int[] secondArray = new int[200000];
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = random.nextInt(100000 * N * 1000);
        }
        System.out.println("Сортировка второго массива выбором:");
        chooseSort(secondArray);
    }


    public static void chooseSort(int[] arr) {
    /*По очереди будем просматривать все подмножества
      элементов массива (0 - последний, 1-последний,
      2-последний,...)*/
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
            int min = arr[i];
            int min_i = i;
        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
            for (int j = i + 1; j < arr.length; j++) {
                //Если находим, запоминаем его индекс
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
        /*Если нашелся элемент, меньший, чем на текущей позиции,
          меняем их местами*/
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
        long finish = System.currentTimeMillis();
        System.out.println("Time = " + (finish - start));
    }

}
