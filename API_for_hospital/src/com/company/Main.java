package com.company;

import com.company1.Patient;

import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static File patientsFile = new File("Patient.txt ");

    public void add() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите данные нового пациента: ");
        try {
            System.out.println("Id: ");
            int Id = in.nextInt();
            System.out.println("Фамилия: ");
            String Surname = in.next();
            System.out.println("Имя: ");
            String Name = in.next();
            System.out.println("Отчество: ");
            String Patronymic = in.next();
            System.out.println("Адресс: ");
            String Adress = in.next();
            System.out.println("Номер телефона: ");
            String Phone = in.next();
            System.out.println("Номер медицинской карточки: ");
            int NumMed = in.nextInt();
            System.out.println("Диагноз: ");
            String Diagnosis = in.next();

            Patient patient = new Patient(Id, Surname, Name, Patronymic, Adress, Phone, NumMed, Diagnosis);
            patients.add(patient);
        } catch (NullPointerException | InputMismatchException ex) {
            System.out.println(ex);
        }
    }

    public void delete(){
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Введите id пациента, которого вы хотите удалить: ");
            int id = in.nextInt();
            for (int i = 0; i <patients.size(); i++) {
                if (patients.get(i).getId() == id) {
                    patients.remove(i);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void writeData(){
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(patientsFile, false))){
            writer.writeObject(patients);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void getData(){
        ArrayList<Patient> h;
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(patientsFile)))
        {
            h = (ArrayList<Patient>)reader.readObject();
            patients = h;

        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e);
        }
    }

    public List filter1(List<Patient> patients, String diagnosis1) throws Exception{
        List<Patient> tmp = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.getDiagnosis().equals(diagnosis1)) {
                tmp.add(patient);
            }
        }
        tmp.sort(Patient::compareTo);
        return tmp;
    }

    public List filter2(List<Patient> patients, int a, int b) throws Exception {
        List<Patient> tmp = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.getNumMed() > a && patient.getNumMed() < b) {
                tmp.add(patient);
            }
        }
        return tmp;
    }

    public List filter3(List<Patient> patients, char c) throws Exception{
        List<Patient> tmp = new ArrayList<>();
        for (Patient patient : patients) {
            if (c == patient.getPhone().charAt(1))
                tmp.add(patient);
        }
        return tmp;
    }

    public Set filter4(List<Patient> patients) throws Exception{
        List<String> list = new ArrayList<>();
        for (Patient patient : patients) {
            list.add(patient.getDiagnosis());
        }
        Collections.sort(list);
        Collections.reverse(list);
        HashSet<String> tmp1 = new HashSet<>(list);
        return tmp1;
    }

    public Set filter5(List<Patient> patients) throws Exception{
        HashSet<String> tmp1 = new HashSet<>();
        for (Patient patient : patients) {
            tmp1.add(patient.getDiagnosis());
        }
        return tmp1;
    }

    public Set filter6(List<Patient> patients) throws Exception{
        HashSet<String> tmp1 = new HashSet<>();
        for (Patient patient : patients) {
            tmp1.add(patient.getDiagnosis());
        }
        return tmp1;
    }

    public void print(List<?> tmp){
        for(Object patient : tmp) {
            System.out.println(tmp);
        }
    }

    public void print1(Set<?> tmp1){
        for(Object patient : tmp1){
            System.out.println(tmp1);
        }
    }

    public void printArray(){
        System.out.println(patients);
    }

    public void start() {
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("Что вы хотите сделать?");
            System.out.println("1 - добавить нового пациента.\n2 - удалить пациента.\n3 - прочитать файл.\n4 - фильтры. " +
                    "\n5 - вывод массива на экран" + "\n6 - записать в файл" + "\n7 - выход");
            int n = in.nextInt();
            switch (n) {
                case 1: {
                    add();
                    while (true){
                        System.out.println("Желаете добавить ещё одного пациента?(1 - да, 0 - нет)");
                        int y = in.nextInt();
                        if (y == 1) {
                            add();
                        } else break;
                    }
                    break;
                }
                case 2: {
                    delete();
                    while (true){
                        System.out.println("Желаете ещё раз произвести удаление?(1 - да, 0 - нет)");
                        int y = in.nextInt();
                        if (y == 1) {
                            delete();
                            System.out.println("Удаление успешно!");
                        } else break;
                    }
                    break;
                }
                case 3: {
                    getData();
                    printArray();
                    break;
                }
                case 4: {
                    if (patients.isEmpty()) {
                        System.out.println("Вы не заполнили коллекцию!");
                        break;
                    } else
                        System.out.println("Введите номер фильтра(1 - 6): ");
                    int k = in.nextInt();
                    switch (k) {
                        case 1: {
                            try {
                                System.out.println("Введите диагноз: ");
                                String diagnosis1 = in.next();
                                print(filter1(patients, diagnosis1));
                            }catch (Exception e){
                                System.out.println(e);
                            }
                            break;
                        }
                        case 2: {
                            try {
                                System.out.println("Введите начало и конец интервала: ");
                                int a = in.nextInt();
                                int b = in.nextInt();
                                print(filter2(patients, a, b));
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        }
                        case 3: {
                            try {
                                System.out.println("Введите первую цифру номера: ");
                                char c = (char) System.in.read();
                                print(filter3(patients, c));
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        }
                        case 4: {
                            try {
                                print1(filter4(patients));
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        }
                        case 5: {
                            try {
                                print1(filter5(patients));
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        }
                        case 6: {
                            try {
                                print1(filter6(patients));
                            }catch (Exception e){
                                System.out.println(e);
                            }
                            break;
                        }
                        default:
                            System.out.println("Вы ничего не ввели!");
                            break;
                    }
                    break;
                }

                case 5: {
                    printArray();
                    while (true){
                        System.out.println("Желаете повторить?(1 - да, 0 - нет)");
                        int y = in.nextInt();
                        if (y == 1) {
                            printArray();
                        }
                        else break;
                    }
                    break;
                }

                case 6: {
                    writeData();
                    break;
                }

                default:
                    break;
            }
            if(n == 7){
                break;
            }
        }
        while (true);
    }

    public static void main(String[] args) {
        Main prog = new Main();
        prog.start();
    }
}
