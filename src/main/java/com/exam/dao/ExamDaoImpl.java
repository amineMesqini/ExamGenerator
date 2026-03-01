package com.exam.dao;

import com.exam.model.Exam;
import com.exam.util.DBConnection;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
public class ExamDaoImpl implements ExamDao {

    @Override
    public void save(Exam exam) {

        String sql = "INSERT INTO exams (titre, description, duree_minutes) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, exam.getTitre());
            stmt.setString(2, exam.getDescription());
            stmt.setInt(3, exam.getDureeMinutes());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Exam> findAll() {

        List<Exam> exams = new ArrayList<>();

        String sql = "SELECT * FROM exams";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Exam exam = new Exam();

                exam.setId(rs.getInt("id"));
                exam.setTitre(rs.getString("titre"));
                exam.setDescription(rs.getString("description"));
                exam.setDureeMinutes(rs.getInt("duree_minutes"));

                exams.add(exam);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return exams;
    }
    @Override
    public Exam findById(int id) {

        Exam exam = null;

        String sql = "SELECT * FROM exams WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                exam = new Exam();
                exam.setId(rs.getInt("id"));
                exam.setTitre(rs.getString("titre"));
                exam.setDescription(rs.getString("description"));
                exam.setDureeMinutes(rs.getInt("duree_minutes"));
                exam.setActive(rs.getBoolean("is_active"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return exam;
    }
    @Override
    public void toggleActive(int examId, boolean active) {

        String sql = "UPDATE exams SET is_active = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setBoolean(1, active);
            stmt.setInt(2, examId);


            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}