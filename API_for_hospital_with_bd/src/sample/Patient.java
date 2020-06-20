package sample;

import java.io.Serializable;

public class Patient implements Serializable{
    private String Surname;
    private String Name;
    private String Patronymic;
    private String Adress;
    private String Phone;
    private int NumMed;

    public Patient(String Surname, String Name, String Patronymic, String Adress, String Phone, int NumMed) {
        this.Surname = Surname;
        this.Name = Name;
        this.Patronymic = Patronymic;
        this.Adress = Adress;
        this.Phone = Phone;
        this.NumMed = NumMed;
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

    @Override
    public String toString() {
        return "Patient{" + "id= " +
                ", Surname='" + Surname + '\'' +
                ", Name='" + Name + '\'' +
                ", Patronymic='" + Patronymic + '\'' +
                ", Address='" + Adress + '\'' +
                ", Phone='" + Phone + '\'' +
                ", NumMed='" + NumMed + '\'' + '}';
    }
}
