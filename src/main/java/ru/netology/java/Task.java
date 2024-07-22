package ru.netology.java;
import java.util.Objects;


public class Task {
   protected int id;


   public Task(int id) {
      this.id = id;
   }
   public int getId() {
      return id;
   }

   //вспомогательные элементы для корректной работы equals, переопределять их в наследниках не нужно
   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null|| getClass() != o.getClass()) return false;
      Task task = (Task) o;
      return id == task.id;
   }
   @Override
   public int hashCode() {
      return Objects.hash(id);
   }


   /*метод проверяет - подходит ли задача поисковому запросу, у каждого наследника эта логика прописана по-своему*/
   public boolean matches(String query) {  //поисковый запрос
      return false;
   }
}
