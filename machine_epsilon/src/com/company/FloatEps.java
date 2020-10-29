package com.company;

public class FloatEps {

    public void calculateEps(){
        long start, end, time;
        int i = 0;
        start = System.nanoTime();
        float e = 1;

        while (1 + e / 2 > 1) {
            e /= 2;
            i++;
        }
        end = System.nanoTime();
        time = (end - start)/1000;
        System.out.println("Float: " + e + "\nTime spent: " + time + "\nIterations ratio: " + i);
    }
}
