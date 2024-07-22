package ru.netology.java;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void testMatchesSimpleTask() {
        Task simpleTask = new SimpleTask(3,"Меню на завтрак");
        boolean expected = true;
        boolean actual = simpleTask.matches("Меню на завтрак");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void testMatchesSimpleTaskFalse() {
        Task simpleTask = new SimpleTask(7,"Что это?");
        boolean expected = false;
        boolean actual = simpleTask.matches("Что?");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void testEpicMatches() {
        String[] subtasks = {"Помыть полы","Вынести мусор","Полить цветы","Приготовить обед"};
        Task epic = new Epic(5,subtasks);
        boolean expected = true;
        boolean actual = epic.matches("Полить цветы");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void testEpicMatchesFalse() {
        String[] subtasks = {"Помыть полы","Вынести мусор","Полить цветы","Приготовить обед"};
        Task epic = new Epic(127,subtasks);
        boolean expected = false;
        boolean actual = epic.matches("сегодня");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void testMeetingMatches() {
        Task meeting = new Meeting(12, "Новые Звездные войны", "Подбор актеров", "1 августа в 12-00");
        boolean expected = true;
        boolean actual = meeting.matches("Подбор актеров");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void testMeetingMatchesFalse() {
        Task meeting = new Meeting(39,"Новые Звездные войны","Подбор актеров","1 августа в 12-00");
        boolean expected = false;
        boolean actual = meeting.matches("Послезавтра");
        Assertions.assertEquals(expected,actual);

    }

}
