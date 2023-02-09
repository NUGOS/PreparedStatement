package ua.goit.preparedstatement.model;

import java.util.Date;

public class Worker {
   Long id;
   String name;
   Date birthday;
   Enum<Level> level;
   int salary;

   public Worker() {
   }

   public Worker(String name, Date birthday, Enum<Level> level, int salary) {
      this.name = name;
      this.birthday = birthday;
      this.level = level;
      this.salary = salary;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public java.sql.Date getBirthday() {
      return (java.sql.Date) birthday;
   }

   public void setBirthday(Date birthday) {
      this.birthday = birthday;
   }

   public Enum<Level> getLevel() {
      return level;
   }

   public void setLevel(Enum<Level> level) {
      this.level = level;
   }

   public int getSalary() {
      return salary;
   }

   public void setSalary(int salary) {
      this.salary = salary;
   }

   @Override
   public String toString() {
      return "Worker{" +
              ", name='" + name + '\'' +
              ", birthday=" + birthday +
              ", level=" + level +
              ", salary=" + salary +
              '}';
   }
}
