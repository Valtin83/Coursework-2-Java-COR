package org.skypro.Coursework2.Java.COR.service;

import org.skypro.Coursework2.Java.COR.model.Question;

import java.util.List;

public interface QuestionService {

    Question addQuestion(String questionText, String answerText);

    boolean removeQuestion(String questionText, String answerText);

    List<Question> getAllQuestions();

    Question getRandomQuestion();
}