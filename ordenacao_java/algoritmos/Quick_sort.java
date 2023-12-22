package ordenacao_java.algoritmos;

public class Quick_sort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int n = arr.length;
        quickSort(arr, 0, n - 1);
    }

    private static void quickSort(int[] arr, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = repartir(arr, inicio, fim);

            quickSort(arr, inicio, indicePivo - 1);
            quickSort(arr, indicePivo + 1, fim);
        }
    }

    private static int repartir(int[] arr, int inicio, int fim) {
        int pivo = arr[fim];
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (arr[j] <= pivo) {
                i++;
                alterar(arr, i, j);
            }
        }

        alterar(arr, i + 1, fim);
        return i + 1;
    }

    private static void alterar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
