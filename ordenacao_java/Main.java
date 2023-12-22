package ordenacao_java;

import ordenacao_java.algoritmos.Bubble_sort;
import ordenacao_java.algoritmos.Counting_sort;
import ordenacao_java.algoritmos.Insertion_sort;
import ordenacao_java.algoritmos.Merge_sort;
import ordenacao_java.algoritmos.Quick_sort;
import ordenacao_java.algoritmos.Selection_sort;
import ordenacao_java.vetores.Vetores;

public class Main {
    public static void main(String[] args) {
        int[][] vetores = {
            Vetores.list_100(),
            Vetores.list_500(),
            Vetores.list_1k(),
            Vetores.list_5k(),
            Vetores.list_30k(),
            Vetores.list_80k(),
            Vetores.list_100k(),
            Vetores.list_150k(),
            Vetores.list_200k()
        };

        testarAlgoritmo("Bubble Sort", Bubble_sort::bubbleSort, vetores);
        testarAlgoritmo("Insertion Sort", Insertion_sort::insertionSort, vetores);
        testarAlgoritmo("Selection Sort", Selection_sort::selectionSort, vetores);
        testarAlgoritmo("Merge Sort", Merge_sort::mergeSort, vetores);
        testarAlgoritmo("Counting Sort", Counting_sort::countingSort, vetores);
        testarAlgoritmo("Quick Sort", Quick_sort::quickSort, vetores);
    }

    private static void testarAlgoritmo(String nomeAlgoritmo, AlgoritmoOrdenacao algoritmo, int[][] vetores) {
        System.out.println("== " + nomeAlgoritmo + " ==");
    
        for (int[] vetor : vetores) {
            int[] copiaVetor = vetor.clone();
            long inicio = System.currentTimeMillis();
            algoritmo.ordenar(copiaVetor);
            long fim = System.currentTimeMillis();
    
            long tempoMilissegundos = fim - inicio;
            double tempoSegundos = tempoMilissegundos / 1000.0;
    
            System.out.printf("Tamanho do vetor: %d - Tempo de execução: %d milissegundos (%.4f segundos)%n",
                    vetor.length, tempoMilissegundos, tempoSegundos);
        }
    
        System.out.println();
    }    

    @FunctionalInterface
    interface AlgoritmoOrdenacao {
        void ordenar(int[] arr);
    }
}
