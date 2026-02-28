package com.exam.dao;

import com.exam.model.User;

public class TestUserDao {

    public static void main(String[] args) {

        UserDao userDao = new UserDaoImpl();

        User user = new User();
        user.setNom("Admin");
        user.setPrenom("System");
        user.setEmail("admin@test.com");
        user.setPassword("1234");
        user.setRole("ADMIN");

        userDao.save(user);

        System.out.println("Utilisateur inséré avec succès !");
    }
}