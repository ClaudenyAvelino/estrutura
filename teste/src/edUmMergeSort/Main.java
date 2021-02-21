package edUmMergeSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] v = {100, 7, 55, 30, 9, 1, 2, 8};
        int[] m = new int[v.length];
        mergeSort(v, m, 0, v.length - 1);
        System.out.println(Arrays.toString(v));
    }

    private static void mergeSort(int[] v, int[] m, int ini, int fim) {
        if (ini < fim) {
            int meio = (ini + fim) / 2;
            mergeSort(v, m, ini, meio);
            mergeSort(v, m, meio + 1, fim);
            intercalar(v, m, ini, meio, fim);
        }
    }

    private static void intercalar(int[] v, int[] w, int ini, int meio, int fim) {
        for (int k = ini; k <= fim; k++)
            w[k] = v[k];
        int i = ini;
        int j = meio + 1;

        for (int k = ini; k <= fim; k++) {
            if (i > meio) v[k] = w[j++];
            else if (j > fim) v[k] = w[i++];
            else if (w[i] < w[j]) v[k] = w[i++];
            else v[k] = w[j++];
        }
    }
}
