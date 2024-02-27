package algoritmos_ordenacao.vetores;

import java.util.Random;

public class Vetores {
    public static int[] criarVetorAleatorio(int tamanho) {
        int[] vetor = new int[tamanho];
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(1000);
        }

        return vetor;
    }

    public static int[] list_100() {
        return criarVetorAleatorio(100);
    }

    public static int[] list_500() {
        return criarVetorAleatorio(500);
    }

    public static int[] list_1k() {
        return criarVetorAleatorio(1000);
    }

    public static int[] list_5k() {
        return criarVetorAleatorio(5000);
    }

    public static int[] list_30k() {
        return criarVetorAleatorio(30000);
    }

    public static int[] list_80k() {
        return criarVetorAleatorio(80000);
    }

    public static int[] list_100k() {
        return criarVetorAleatorio(100000);
    }

    public static int[] list_150k() {
        return criarVetorAleatorio(150000);
    }

    public static int[] list_200k() {
        return criarVetorAleatorio(200000);
    }
}
