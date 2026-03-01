package com.exam.model;

import java.sql.Timestamp;

public class Result {

    private int id;
    private int userId;
    private int examId;
    private float score;
    private int tempsPasseSecondes;
    private Timestamp dateTentative;

    // 🔥 Infos supplémentaires (JOIN avec users)
    private String nom;
    private String prenom;

    // =============================
    // GETTERS & SETTERS
    // =============================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getTempsPasseSecondes() {
        return tempsPasseSecondes;
    }

    public void setTempsPasseSecondes(int tempsPasseSecondes) {
        this.tempsPasseSecondes = tempsPasseSecondes;
    }

    public Timestamp getDateTentative() {
        return dateTentative;
    }

    public void setDateTentative(Timestamp dateTentative) {
        this.dateTentative = dateTentative;
    }

    // 🔥 nom & prenom (JOIN users)

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}