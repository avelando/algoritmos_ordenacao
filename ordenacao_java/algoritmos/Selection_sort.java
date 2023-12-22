package ordenacao_java.algoritmos;

public class Selection_sort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int menor = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[menor]) {
                    menor = j;
                }
            }

            if (menor != i) {
                int temp = arr[i];
                arr[i] = arr[menor];
                arr[menor] = temp;
            }
        }
    }
}
