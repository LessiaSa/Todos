package ru.netology.java;


public class Todos {
    private Task[] tasks = new Task[0]; //<- тут будут все задачи

//метод для имитации добавления элемента в массив
    private Task[] addToArray(Task[] current, Task task) {
        Task[] tmp = new Task[current.length + 1];
        for (int i =0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = task;
        return tmp;
    }


    //метод добавления задачи в список дел
    public void add(Task task) {
        tasks = addToArray(tasks,task);  //task - добавляемая задача
    }
    public Task[] findAll() {
        return tasks;
    }

    /*метод поиска задач, которые подходят под поисковый запрос*/
    public Task[] search(String query) {  //поисковый запрос
        Task[] result = new Task[0];//массив для ответа
        for(Task task: tasks) {    //перебираем все задачи
            if (task.matches(query)) {  //если задача подходит под запрос
                result = addToArray(result,task); //добавляем ее в массив ответа
            }
        }
        return result;
    }
}
