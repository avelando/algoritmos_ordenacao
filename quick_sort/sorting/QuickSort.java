package quick_sort.sorting;

public class QuickSort {

    public static int hoareQuickSort(int[] arr, int low, int high) {
        int[] trocas = {0}; 
        hoareQuickSort(arr, low, high, trocas);
        return trocas[0];
    }

    private static void hoareQuickSort(int[] arr, int low, int high, int[] trocas) {
        if (low < high) {
            int pivotIndex = hoarePartition(arr, low, high, trocas);

            hoareQuickSort(arr, low, pivotIndex, trocas);
            hoareQuickSort(arr, pivotIndex + 1, high, trocas);
        }
    }

    private static int hoarePartition(int[] arr, int low, int high, int[] trocas) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) {
                return j;
            }

            swap(arr, i, j);
            trocas[0]++;
        }
    }

    public static int lomutoQuickSort(int[] arr, int low, int high) {
        int[] trocas = {0};
        lomutoQuickSort(arr, low, high, trocas);
        return trocas[0];
    }

    private static void lomutoQuickSort(int[] arr, int low, int high, int[] trocas) {
        if (low < high) {
            int pivotIndex = lomutoPartition(arr, low, high, trocas);

            lomutoQuickSort(arr, low, pivotIndex - 1, trocas);
            lomutoQuickSort(arr, pivotIndex + 1, high, trocas);
        }
    }

    private static int lomutoPartition(int[] arr, int low, int high, int[] trocas) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
                trocas[0]++;
            }
        }

        swap(arr, i + 1, high);
        trocas[0]++;
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
