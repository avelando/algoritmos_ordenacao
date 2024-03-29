package algoritmos_ordenacao.algoritmos;

public class Insertion_sort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; ++i) {
            int chave = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > chave) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = chave;
        }
    }
}
