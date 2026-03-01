package com.exam.model;

public class Question {

    private int id;
    private int examId;
    private String contenu;
    private String typeQuestion; // QCM, TEXTE_A_TROUS, COURTE_REPONSE
    private float points;
    private Integer ordre;

    public Question() {
    }

    public Question(int examId, String contenu,
                    String typeQuestion, float points, Integer ordre) {
        this.examId = examId;
        this.contenu = contenu;
        this.typeQuestion = typeQuestion;
        this.points = points;
        this.ordre = ordre;
    }

    // ===== GETTERS =====

    public int getId() {
        return id;
    }

    public int getExamId() {
        return examId;
    }

    public String getContenu() {
        return contenu;
    }

    public String getTypeQuestion() {
        return typeQuestion;
    }

    public float getPoints() {
        return points;
    }

    public Integer getOrdre() {
        return ordre;
    }

    // ===== SETTERS =====

    public void setId(int id) {
        this.id = id;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setTypeQuestion(String typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public void setPoints(float points) {
        this.points = points;
    }

    public void setOrdre(Integer ordre) {
        this.ordre = ordre;
    }
}