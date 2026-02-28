package com.exam.model;

public class Question {

    private int id;
    private String contenu;
    private String choixA;
    private String choixB;
    private String choixC;
    private String choixD;
    private String bonneReponse; // A, B, C ou D
    private int examId; // lien vers Exam

    public Question() {}

    public Question(int id, String contenu, String choixA, String choixB,
                    String choixC, String choixD, String bonneReponse, int examId) {
        this.id = id;
        this.contenu = contenu;
        this.choixA = choixA;
        this.choixB = choixB;
        this.choixC = choixC;
        this.choixD = choixD;
        this.bonneReponse = bonneReponse;
        this.examId = examId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getContenu() { return contenu; }
    public void setContenu(String contenu) { this.contenu = contenu; }

    public String getChoixA() { return choixA; }
    public void setChoixA(String choixA) { this.choixA = choixA; }

    public String getChoixB() { return choixB; }
    public void setChoixB(String choixB) { this.choixB = choixB; }

    public String getChoixC() { return choixC; }
    public void setChoixC(String choixC) { this.choixC = choixC; }

    public String getChoixD() { return choixD; }
    public void setChoixD(String choixD) { this.choixD = choixD; }

    public String getBonneReponse() { return bonneReponse; }
    public void setBonneReponse(String bonneReponse) { this.bonneReponse = bonneReponse; }

    public int getExamId() { return examId; }
    public void setExamId(int examId) { this.examId = examId; }
}