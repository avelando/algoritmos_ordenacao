package algoritmos_ordenacao.algoritmos;

public class Counting_sort {
    public static void countingSort(int[] arr) {
        int max = maximo(arr);
        int min = minimo(arr);

        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        for (int i : arr) {
            count[i - min]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    private static int maximo(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private static int minimo(int[] arr) {
        int min = arr[0];
        for (int i : arr) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
}
