package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double tax, fee;
        System.out.println("Введите сумму в евро: ");
        double sum = in.nextDouble();
        if(sum < 100 && sum > 0) {
            System.out.println("Сумма не облагается!");
        }
        else if(sum > 100) {
            sum = sum - 100;
            tax = tax(sum);
            fee = fee(sum);
            System.out.println("Налог: " + tax);
            System.out.println("Пошлина: " + fee);
        }
        else System.out.println("Некорректный ввод!");
    }

    public static double tax(double sum){
        double tax = 0;
        tax = sum  * 0.2;
        return tax;
    }

    public static double fee(double sum){
        double fee = 0;
        fee = sum * 0.1;
        return fee;
    }
}
