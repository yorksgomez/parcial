package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorting {

    public static List<Double> qck(List<Double> data, int inicio, int fin) {
        if(inicio < fin) {
            int p = partition(data, inicio, fin);
            qck(data, inicio, p - 1);
            qck(data, p + 1, fin);
            return data;
        }

        return data;
    }

    private static int partition(List<Double> data, int inicio, int fin) {
        int p = fin;

        for(int i = inicio; i < p; i++) {
            if(data.get(p) <= data.get(i)) {
                data.add(p + 1, data.get(i));
                data.remove(i);
                p--;
                i--;
            }
        }

        return p;
    }

}
