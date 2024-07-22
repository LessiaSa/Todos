package ru.netology.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(meeting);
        todos.add(epic);

        Task[] expected = {simpleTask, meeting, epic};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetSubtasks() {
        String[] subtasks = {"Помыть полы", "Вынести мусор", "Полить цветы", "Приготовить обед"};
        Epic epic = new Epic(37, subtasks);
        String[] expected = subtasks;
        String[] actual = epic.getSubtasks();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetEpic() {
        String[] subtasks = {"Помыть полы", "Вынести мусор", "Полить цветы", "Приготовить обед"};
        Epic epic = new Epic(37, subtasks);
        Task task = new Task(37);
        int expected = 37;
        int actual = task.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearch() {
        SimpleTask simpleTask = new SimpleTask(9, "Меню на завтрак");
        String[] subtasks = {"Помыть полы", "Вынести мусор", "Полить цветы", "Приготовить обед"};
        Epic epic = new Epic(14, subtasks);
        Meeting meeting = new Meeting(24, "Новые Звездные войны", "Подбор актеров", "1 августа в 12-00");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(meeting);
        todos.add(epic);
        Task[] expected = {simpleTask, meeting, epic};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetTitle() {
        SimpleTask simpleTask = new SimpleTask(9, "Меню на завтрак");
        String[] subtasks = {"Помыть полы", "Вынести мусор", "Полить цветы", "Приготовить обед"};
        Epic epic = new Epic(14, subtasks);
        Meeting meeting = new Meeting(24, "Новые Звездные войны", "Подбор актеров", "1 августа в 12-00");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(meeting);
        todos.add(epic);
        Task[] expected = {simpleTask};
        Task[] actual = todos.search(simpleTask.getTitle());
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testPartEpic() {
        SimpleTask simpleTask = new SimpleTask(9, "Меню на завтрак");
        String[] subtasks = {"Помыть полы", "Вынести мусор", "Полить цветы", "Приготовить обед"};
        Epic epic = new Epic(14, subtasks);
        Meeting meeting = new Meeting(24, "Новые Звездные войны", "Подбор актеров", "1 августа в 12-00");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(meeting);
        todos.add(epic);
        Task[] expected = {epic};
        Task[] actual = todos.search("цветы");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testPartMeetingTopic() {
        SimpleTask simpleTask = new SimpleTask(9, "Меню на завтрак");
        String[] subtasks = {"Помыть полы", "Вынести мусор", "Полить цветы", "Приготовить обед"};
        Epic epic = new Epic(14, subtasks);
        Meeting meeting = new Meeting(24, "Новые Звездные войны", "Подбор актеров", "1 августа в 12-00");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(meeting);
        todos.add(epic);
        Task[] expected = {meeting};
        Task[] actual = todos.search(meeting.getTopic());
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testPartMeetingProject() {
        SimpleTask simpleTask = new SimpleTask(9, "Меню на завтрак");
        String[] subtasks = {"Помыть полы", "Вынести мусор", "Полить цветы", "Приготовить обед"};
        Epic epic = new Epic(14, subtasks);
        Meeting meeting = new Meeting(24, "Новые Звездные войны", "Подбор актеров", "1 августа в 12-00");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(meeting);
        todos.add(epic);
        Task[] expected = {meeting};
        Task[] actual = todos.search(meeting.getProject());
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testPartMeetingStart() {
        SimpleTask simpleTask = new SimpleTask(9, "Меню на завтрак");
        String[] subtasks = {"Помыть полы", "Вынести мусор", "Полить цветы", "Приготовить обед"};
        Epic epic = new Epic(14, subtasks);
        Meeting meeting = new Meeting(24, "Новые Звездные войны", "Подбор актеров", "1 августа в 12-00");
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(meeting);
        todos.add(epic);
        Task[] expected = {meeting};
        Task[] actual = todos.search(meeting.getStart());
        Assertions.assertArrayEquals(expected, actual);
    }
}
