package com.exam.dao;

import com.exam.model.Result;
import java.util.List;

public interface ResultDao {

    List<Result> findByExamId(int examId);
}