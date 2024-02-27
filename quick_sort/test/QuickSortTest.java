package quick_sort.test;

import quick_sort.sorting.QuickSort;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000, 5000, 30000, 80000, 100000, 150000, 200000};

        for (int size : sizes) {
            int[] array = generateRandomArray(size);

            int[] arrayHoare = array.clone();
            long startTimeHoare = System.currentTimeMillis();
            int trocasHoare = QuickSort.hoareQuickSort(arrayHoare, 0, arrayHoare.length - 1);
            long endTimeHoare = System.currentTimeMillis();
            System.out.println("Hoare QuickSort: Tamanho = " + size + ", Trocas = " + trocasHoare + ", Tempo = " + (endTimeHoare - startTimeHoare) + "ms");

            int[] arrayLomuto = array.clone();
            long startTimeLomuto = System.currentTimeMillis();
            int trocasLomuto = QuickSort.lomutoQuickSort(arrayLomuto, 0, arrayLomuto.length - 1);
            long endTimeLomuto = System.currentTimeMillis();
            System.out.println("Lomuto QuickSort: Tamanho = " + size + ", Trocas = " + trocasLomuto + ", Tempo = " + (endTimeLomuto - startTimeLomuto) + "ms");

            System.out.println();
        }
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * size);
        }
        return array;
    }
}
