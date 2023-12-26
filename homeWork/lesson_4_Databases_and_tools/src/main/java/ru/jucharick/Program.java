package ru.jucharick;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.jucharick.Course;

/*
Создайте базу данных (например, SchoolDB).
В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
Настройте Hibernate для работы с вашей базой данных.
Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
Убедитесь, что каждая операция выполняется в отдельной транзакции.
*/

public class Program {
    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()){

            // Создание сессии
            Session session = sessionFactory.getCurrentSession();

            // Начало транзакции
            session.beginTransaction();

            // Создание объекта
            Course course1 = new Course("Java_Junior", 6);
            session.save(course1);
            System.out.println("Object course save successfully");

            Course course2 = new Course("JDK", 8);
            session.save(course2);
            System.out.println("Object course save successfully");

            Course course3 = new Course("Java Core", 9);
            session.save(course3);
            System.out.println("Object course save successfully");

            Course course4 = new Course("Framework Spring", 5);
            session.save(course4);
            System.out.println("Object course save successfully");

            Course course5 = new Course("JDK", 8);
            session.save(course5);
            System.out.println("Object course save successfully");

            session.getTransaction().commit();

            // Создание сессии
            Session session_1 = sessionFactory.getCurrentSession();
            // Начало транзакции
            session_1.beginTransaction();

            // Чтение объекта из базы данных
            Course retrievedCourse = session_1.get(Course.class, course2.getId());
            System.out.println("Object course retrieved successfully");
            System.out.println("Retrieved course object: " + retrievedCourse);

            session_1.getTransaction().commit();

            // Создание сессии
            Session session_2 = sessionFactory.getCurrentSession();
            // Начало транзакции
            session_2.beginTransaction();

            // Обновление объекта
            retrievedCourse.updateTitle("Java Development Kit");
            retrievedCourse.updateDuration(10);
            session_2.update(retrievedCourse);
            System.out.println("Object course update successfully");

            session_2.getTransaction().commit();

            // Создание сессии
            Session session_3 = sessionFactory.getCurrentSession();
            // Начало транзакции
            session_3.beginTransaction();

            Course deleteCourse = session_3.get(Course.class, course5.getId());
            session_3.delete(deleteCourse);
            System.out.println("Object course delete successfully");

            session_3.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
