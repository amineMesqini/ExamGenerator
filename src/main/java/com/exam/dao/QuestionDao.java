package com.exam.dao;

import com.exam.model.Question;

import java.util.List;

public interface QuestionDao {

    int save(Question question);
    List<Question> findByExamId(int examId);

}