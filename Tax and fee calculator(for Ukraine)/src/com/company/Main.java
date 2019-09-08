package com.company;

import java.util.Scanner;

public class Main {

    public void comparator(){
        double sum = input(), tax, fee;
        if(sum < 100 && sum > 0) {
            System.out.println("This sum can not be taxed!");
        }
        else if(sum > 100) {
            sum = sum - 100;
            tax = tax(sum);
            fee = fee(sum);
            System.out.println("Tax: " + tax);
            System.out.println("Fee: " + fee);
        }
        else System.out.println("Incorrect input!");
    }

    public double input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Input the sum in euros: ");
        double sum = in.nextDouble();
        return sum;
    }

    public double tax(double sum){
        double tax;
        tax = sum  * 0.2;
        return tax;
    }

    public double fee(double sum){
        double fee;
        fee = sum * 0.1;
        return fee;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.comparator();
    }
}
