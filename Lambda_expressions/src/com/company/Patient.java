package com.company;

import java.io.Serializable;

public class Patient implements Serializable, Comparable<Patient>{
    private int id;
    private String Surname;
    private String Name;
    private String Patronymic;
    private String Adress;
    private String Phone;
    private int NumMed;
    private String Diagnosis;

    public Patient(int id, String Surname, String Name, String Patronymic, String Adress, String Phone, int NumMed, String Diagnosis) {
        this.id = id;
        this.Surname = Surname;
        this.Name = Name;
        this.Patronymic = Patronymic;
        this.Adress = Adress;
        this.Phone = Phone;
        this.NumMed = NumMed;
        this.Diagnosis = Diagnosis;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getSurname(){
        return Surname;
    }

    public void setSurname(String Surname){
        this.Surname = Surname;
    }

    public String getName(){
        return Name;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public String getPatronymic(){
        return Patronymic;
    }

    public void setPatronymic(String Patronymic){
        this.Patronymic = Patronymic;
    }

    public String getAdress(){
        return Adress;
    }

    public void setAdress(String Adress){
        this.Adress = Adress;
    }

    public String getPhone(){
        return Phone;
    }

    public void setPhone(String Phone){
        this.Phone = Phone;
    }

    public int getNumMed(){
        return NumMed;
    }

    public void setNumMed(int NumMed){
        this.NumMed = NumMed;
    }

    public String getDiagnosis(){
        return Diagnosis;
    }

    public void setDiagnosis(String Diagnosis){
        this.Diagnosis = Diagnosis;
    }

    @Override
    public String toString() {
        return "Patient{" + "id= " + id +
                ", Surname='" + Surname + '\'' +
                ", Name='" + Name + '\'' +
                ", Patronymic='" + Patronymic + '\'' +
                ", Address='" + Adress + '\'' +
                ", Phone='" + Phone + '\'' +
                ", NumMed='" + NumMed + '\'' +
                ", Diagnosis='" + Diagnosis + '}';
    }

    @Override
    public int compareTo(Patient o) {
        return Integer.compare(o.NumMed, this.NumMed);
    }
}

