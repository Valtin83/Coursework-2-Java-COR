package org.skypro.Coursework2.Java.COR.service;

import org.skypro.Coursework2.Java.COR.model.Question;

import java.util.List;

public interface ExaminerService {
    List<Question> getQuestions(Integer amount);
}