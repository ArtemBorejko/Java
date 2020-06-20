package sample;

public class Diagnosis {
    private int id;
    private String diagnosis;

    public Diagnosis(int id, String diagnosis){
        this.id = id;
        this.diagnosis = diagnosis;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
