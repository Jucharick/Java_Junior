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
            System.out.println("Object student save successfully");

            Course course2 = new Course("JDK", 8);
            session.save(course1);
            System.out.println("Object student save successfully");

            Course course3 = new Course("Java Core", 9);
            session.save(course1);
            System.out.println("Object student save successfully");

            Course course4 = new Course("Framework Spring", 5);
            session.save(course1);
            System.out.println("Object student save successfully");

            // Чтение объекта из базы данных
            Course retrievedCourse = session.get(Course.class, course2.getId());
            System.out.println("Object student retrieved successfully");
            System.out.println("Retrieved student object: " + retrievedCourse);

            // Обновление объекта
            retrievedCourse.updateTitle("Java Development Kit");
            retrievedCourse.updateDuration(10);
            session.update(retrievedCourse);
            System.out.println("Object student update successfully");


            session.delete(retrievedCourse);
            System.out.println("Object student delete successfully");

            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
