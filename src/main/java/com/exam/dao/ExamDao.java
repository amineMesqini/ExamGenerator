package com.exam.dao;

import com.exam.model.Exam;

import java.util.List;

public interface ExamDao {

    void save(Exam exam);
    List<Exam> findAll();
    Exam findById(int id);
    void toggleActive(int examId, boolean active);

}
