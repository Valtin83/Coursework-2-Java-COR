package org.skypro.Coursework2.Java.COR.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.Coursework2.Java.COR.model.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceImplTest {

    private JavaQuestionServiceImpl questionService;

    @BeforeEach
    void setUp() {
        // Инициализируем сервис перед каждым тестом
        questionService = new JavaQuestionServiceImpl();
    }

    @Test
    void testAddQuestion() {
        // Добавляем вопрос
        questionService.addQuestion("Что такое Java?", "Программирование");

        // Проверяем, что вопрос добавлен
        List<Question> questions = questionService.getAllQuestions();
        assertEquals(1, questions.size());
        assertEquals("Что такое Java?", questions.get(0).getQuestion());
        assertEquals("Программирование", questions.get(0).getAnswer());
    }

    @Test
    void testRemoveQuestion() {
        // Добавляем вопрос
        questionService.addQuestion("Что такое Java?", "Программирование");
        questionService.addQuestion("Что такое Python?", "Язык программирования");

        // Удаляем один из вопросов
        questionService.removeQuestion("Что такое Java?", "Программирование");

        // Проверяем, что остался только один вопрос
        List<Question> questions = questionService.getAllQuestions();
        assertEquals(1, questions.size());
        assertEquals("Что такое Python?", questions.get(0).getQuestion());
    }

    @Test
    void testGetAllQuestions() {
        // Добавляем несколько вопросов
        questionService.addQuestion("Что такое Java?", "Программирование");
        questionService.addQuestion("Что такое Python?", "Язык программирования");

        // Проверяем, что все вопросы возвращаются
        List<Question> questions = questionService.getAllQuestions();
        assertEquals(2, questions.size());
    }


    @Test
    public void testGetRandomQuestion() {
        JavaQuestionServiceImpl service = new JavaQuestionServiceImpl();
        service.addQuestion("Что такое Java?", "Язык программирования");

        Question question = service.getRandomQuestion();
        assertNotNull(question);
        assertEquals("Что такое Java?", question.getQuestion());
    }
}