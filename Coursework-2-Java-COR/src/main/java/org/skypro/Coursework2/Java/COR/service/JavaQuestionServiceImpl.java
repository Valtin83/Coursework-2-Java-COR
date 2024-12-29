package org.skypro.Coursework2.Java.COR.service;

import org.skypro.Coursework2.Java.COR.exception.NoQuestionsAvailableException;
import org.skypro.Coursework2.Java.COR.exception.QuestionNotFoundException;
import org.skypro.Coursework2.Java.COR.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionServiceImpl implements QuestionService {

    private final List<Question> questions = new ArrayList<>();

    @Override
    public Question addQuestion(String questionText, String answerText) {
        Question question = new Question(questionText, answerText);
        if (!questions.contains(question)) {
            questions.add(question);
            return question;
        } else {
            throw new QuestionNotFoundException("Вопрос уже существует.");
        }

    }

    @Override
    public boolean removeQuestion(String questionText, String answerText) {
        boolean isRemoved = questions.removeIf(q -> q.getQuestion().equals(questionText) && q.getAnswer().equals(answerText));
        if (!isRemoved) {
            throw new QuestionNotFoundException("Вопрос не найден.");
        }
        return true;
    }

    @Override
    public List<Question> getAllQuestions() {
        return List.copyOf(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new NoQuestionsAvailableException("Нет доступных вопросов.");
        }
        int randomIndex = new Random().nextInt(questions.size());
        return questions.get(randomIndex);
    }
}