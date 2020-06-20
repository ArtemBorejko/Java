package sample;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run(){

        menu();
    }

    public void menu(){
        BDController DataController = new BDController("jdbc:mysql://localhost:3306/patient?serverTimezone=UTC", "root", "12345");
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("1 - Работа с пациентами\n");
            System.out.print("2 - Работа с диагнозами\n");
            System.out.print("3 - Выход\n");
            System.out.print(">>> ");
            int num = in.nextInt();
            switch (num){
                case 1:
                    patientsMenu(DataController);
                    break;
                case 2:
                    diagnosisMenu(DataController);
                    break;
                case 3:
                    return;
                default:break;
            }
        }
    }

    public void patientsMenu(BDController DataController){
        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.print("1 - Добавить нового пациента.\n");
            System.out.print("2 - Найти пациента.\n");
            System.out.print("3 - Список пациентов.\n");
            System.out.print("4 - Назад\n");
            System.out.print(">>> ");
            int num = in.nextInt();
            switch (num) {
                case 1:
                    in.nextLine();
                    int NumMed;
                    String Surname, Name, Patronymic,  Adress, Phone;
                    System.out.print("Номер Медкарты: " + (DataController.getMaxId() + 1) + "\n");
                    System.out.print("Фамилия: ");
                    Surname = in.nextLine();
                    System.out.println("Имя: ");
                    Name = in.nextLine();
                    System.out.println("Отчество: ");
                    Patronymic = in.nextLine();
                    System.out.print("Адрес: ");
                    Adress = in.nextLine();
                    System.out.print("Телефон: ");
                    Phone = in.nextLine();
                    System.out.println("Номер медицинской карты: ");
                    NumMed = in.nextInt();
                    DataController.addPatient(new Patient(Surname, Name, Patronymic, Adress, Phone, NumMed));
                    System.out.print("Пациент добавлен.");
                    System.out.print("Для продолжения нажмите Enter...");
                    in.nextLine();
                    in.nextLine();
                    break;
                case 2:
                    System.out.print("Номер медкарты:  ");
                    Patient patient = DataController.getPatient(in.nextInt());
                    if (patient == null) {
                        System.out.print("Пациент с таким номером медкарты не зарегестрирован!!!\n");
                        System.out.print("\nДля продолжения нажмите Enter...");
                        in.nextLine();in.nextLine();
                        return;
                    }
                    System.out.print("\n" + patient.toString());
                    while (true) {
                        boolean b = false;
                        System.out.print("\n1 - Добавить диагноз\n");
                        System.out.print("2 - Список заболеваний\n");
                        System.out.print("3 - Назад\n");
                        System.out.print(">>> ");
                        num = in.nextInt();
                        switch (num) {
                            case 1:
                                patientssMenuAddDiagnos(DataController, patient);
                                break;
                            case 2:
                                ArrayList<String> data = DataController.getPatientDiagnos(patient.getNumMed());
                                System.out.print("Количество заболеваний: " + data.size() + "\n");
                                for(String a: data){
                                    System.out.print(a + "\n");
                                }
                                break;
                            case 3:
                                b = true;
                                break;
                            default:
                                break;
                        }
                        if (b == true) break;
                        System.out.print("\nДля продолжения нажмите Enter...");
                        in.nextLine();
                        in.nextLine();
                    }
                    break;
                case 3:
                    ArrayList<Patient> patients = DataController.getPatient();
                    for (Patient a : patients)
                        System.out.print(a.getSurname() + "; " + a.getName() + "; " + a.getPatronymic() + "; " + a.getAdress() + "; " + a.getPhone() + "; " +
                                a.getNumMed() + "\n");
                    System.out.print("\nДля продолжения нажмите Enter...");
                    in.nextLine();
                    in.nextLine();
                    break;
                case 4:
                    return;
                default:
                    break;
            }
        }
    }

    public void patientssMenuAddDiagnos(BDController DataController, Patient patient){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите код диагноза: ");
        String str = in.nextLine();
        try{
            DataController.addPatientDiagnos(patient.getNumMed(), str);
            System.out.print("Диагноз добавлен.");
        }catch (SQLException ex){
            System.out.print("Такой диагноз не зарегестрирован в системе.");
        }
    }

    public void diagnosisMenu(BDController DataController){

        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.print("1 - Список диагнозов в системе\n");
            System.out.print("2 - Добавить диагноз в систему\n");
            System.out.print("3 - Назад\n");
            System.out.print(">>> ");
            int num = in.nextInt();
            switch (num) {
                case 1:
                    ArrayList<Diagnosis> diagnosis = DataController.getDiagnosis();
                    for (Diagnosis a : diagnosis) {
                        System.out.print(a.getId() + " - " + a.getDiagnosis() + "\n");
                    }
                    System.out.print("\nДля продолжения нажмите Enter...");
                    in.nextLine();
                    in.nextLine();
                    break;
                case 2:
                    in.nextLine();
                    System.out.print("Код диагноза: ");
                    String a = in.nextLine();
                    System.out.print("Диагноз: ");
                    String diagnos = in.nextLine();
                    try {
                        DataController.addDiagnos(a, diagnos);
                        System.out.print("Диагноз добавлен.");
                    } catch (SQLException ex) {
                        System.out.print("Такой код диагноза уже cуществует в системе!!!");
                    }
                    System.out.print("\nДля продолжения нажмите Enter...");
                    in.nextLine();
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
    }
}

