package com.exam.dao;

import com.exam.model.Question;
import com.exam.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoImpl implements QuestionDao {
    @Override
    public int save(Question question) {

        String sql = "INSERT INTO questions " +
                "(exam_id, contenu, type_question, points, ordre) " +
                "VALUES (?, ?, ?, ?, ?)";

        int generatedId = -1;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, question.getExamId());
            stmt.setString(2, question.getContenu());
            stmt.setString(3, question.getTypeQuestion());
            stmt.setFloat(4, question.getPoints());

            if (question.getOrdre() != null) {
                stmt.setInt(5, question.getOrdre());
            } else {
                stmt.setNull(5, java.sql.Types.INTEGER);
            }

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return generatedId;
    }
    @Override
    public List<Question> findByExamId(int examId) {

        List<Question> questions = new ArrayList<>();

        String sql = "SELECT * FROM questions WHERE exam_id = ? ORDER BY ordre";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, examId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setExamId(rs.getInt("exam_id"));
                question.setContenu(rs.getString("contenu"));
                question.setTypeQuestion(rs.getString("type_question"));
                question.setPoints(rs.getFloat("points"));
                question.setOrdre(rs.getInt("ordre"));

                questions.add(question);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return questions;
    }

}