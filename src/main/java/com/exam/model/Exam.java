package com.exam.model;

import java.time.LocalDateTime;

public class Exam {

    private int id;
    private String titre;
    private String description;
    private int dureeMinutes;
    private LocalDateTime dateDebut;
    private boolean isActive;
    private Integer adminId;

    public Exam() {}

    public Exam(String titre, String description, int dureeMinutes) {
        this.titre = titre;
        this.description = description;
        this.dureeMinutes = dureeMinutes;
        this.isActive = false;
    }



    public String getTitre() { return titre; }
    public String getDescription() { return description; }
    public int getDureeMinutes() { return dureeMinutes; }

    public void setTitre(String titre) { this.titre = titre; }
    public void setDescription(String description) { this.description = description; }
    public void setDureeMinutes(int dureeMinutes) { this.dureeMinutes = dureeMinutes; }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}