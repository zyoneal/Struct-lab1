import java.util.Random;

public class Array {
    private final int N = 6;

    public static void main(String[] args) {
        Array prog = new Array();
        prog.run();
    }

    public void run() {
        int N = 6;
        System.out.println("Массив: ");
        int[] firstArray = createFillArray(100000, N);
        System.out.println("Количество чисел в диапазоне N - 2*N = " + countNumbers(N, firstArray));
        // index 1000+N
        System.out.println("Find min index:");
        findIndex(N, firstArray);
        //сортировка массива выбором + время
        System.out.println("Сортировка первого массива выбором:");
        long time1 = chooseSort(firstArray);
        System.out.println("time :" + time1);
        //массив в 2 раза больше
        System.out.println("Массив в 2 раза больше: ");
        int[] secondArray = createFillArray(200000, N);
        System.out.println("Сортировка второго массива выбором:");
        long time2 = chooseSort(secondArray);
        System.out.println("time :" + time2);// sravnenie vopros
    }

    public int[] createFillArray(int size, int N) {
        int[] firstArray = new int[size];
        Random random = new Random();
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = random.nextInt(size + N * 1000);
        }
        return firstArray;
    }

    public int countNumbers(int N, int[] firstArray) {
        int k = 0;
        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] >= N && firstArray[i] <= N * 2) {
                k++;
            }
            ;
        }
        return k;
    }

    public long chooseSort(int[] arr) {
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
        long iter = finish - start;
        return iter;
    }

    public int findIndex(int N, int[] firstArray) {
        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] == 1000 + N) {
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }
}
