package com.company;

import java.util.Scanner;
import java.lang.String;

    public class Main {
        public static void main(String[] args) {
            Main main = new Main();
            Scanner in = new Scanner(System.in);
            System.out.println("Введите строку: ");
            String str = in.nextLine();
            StringBuffer sb = new StringBuffer(str);
            int index_p = str.indexOf('р');
            if (index_p == -1) {
                int index_P = str.indexOf('Р');
                main.replace(str, sb, index_P);
            } else
                main.replace(str, sb, index_p);
            main.output(str, sb);
        }

        private void replace(String str, StringBuffer sb, int index_p) {
            int index_a = str.indexOf('а', index_p);
            if (index_p + 1 == index_a) {
                sb.deleteCharAt(index_a);
                sb.insert(index_a, 'о');
            }
        }

        public void output(String str, StringBuffer sb){
            System.out.println(str);
            System.out.println(sb);
        }
    }
