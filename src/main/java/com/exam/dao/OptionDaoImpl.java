package com.exam.dao;

import com.exam.model.Option;
import com.exam.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OptionDaoImpl implements OptionDao {

    @Override
    public void save(Option option) {

        String sql = "INSERT INTO options (question_id, texte_option, is_correct) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, option.getQuestionId());
            stmt.setString(2, option.getTexteOption());
            stmt.setBoolean(3, option.isCorrect());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}