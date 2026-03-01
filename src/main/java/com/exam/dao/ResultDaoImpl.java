package com.exam.dao;

import com.exam.model.Result;
import com.exam.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultDaoImpl implements ResultDao {

    @Override
    public List<Result> findByExamId(int examId) {

        List<Result> results = new ArrayList<>();

        String sql = """
                SELECT r.*, u.nom, u.prenom
                FROM results r
                JOIN users u ON r.user_id = u.id
                WHERE r.exam_id = ?
                """;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, examId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Result result = new Result();

                result.setId(rs.getInt("id"));
                result.setExamId(rs.getInt("exam_id"));
                result.setUserId(rs.getInt("user_id"));
                result.setScore(rs.getFloat("score"));
                result.setTempsPasseSecondes(rs.getInt("temps_passe_secondes"));
                result.setDateTentative(rs.getTimestamp("date_tentative"));

                result.setNom(rs.getString("nom"));
                result.setPrenom(rs.getString("prenom"));

                results.add(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }
}