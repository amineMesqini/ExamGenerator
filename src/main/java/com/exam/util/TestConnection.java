package com.exam.util;

import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DBConnection.getConnection();
            if (conn != null) {
                System.out.println("Connexion réussie à MySQL !");
                conn.close();
            }
        } catch (Exception e) {
            System.out.println("Erreur de connexion !");
            e.printStackTrace();
        }
    }
}