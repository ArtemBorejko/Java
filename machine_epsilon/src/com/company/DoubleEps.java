package com.company;

public class DoubleEps {

    public void calculateEps(){
        long start, end, time;
        int i = 0;
        start = System.nanoTime();
        double e = 1;

        while (1 + e / 2 > 1) {
            e /= 2;
            i++;
        }
        end = System.nanoTime();
        time = end - start;
        System.out.println("Double: " + e + "\nTime spent: " + time + "\nIterations ratio: " + i);
    }
}
