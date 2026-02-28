package com.exam.model;

public class Exam {

    private int id;
    private String titre;
    private String description;
    private int duree; // en minutes

    public Exam() {}

    public Exam(int id, String titre, String description, int duree) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.duree = duree;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getDuree() { return duree; }
    public void setDuree(int duree) { this.duree = duree; }
}