package algoritmos_ordenacao.algoritmos;

public class Bubble_sort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean troca;

        for (int i = 0; i < n - 1; i++) {
            troca = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    troca = true;
                }
            }

            if (!troca) {
                break;
            }
        }
    }
}
