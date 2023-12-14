package ru.jucharick;

/*
1. Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
Обеспечьте поддержку сериализации для этого класса. Создайте объект класса Student и инициализируйте его данными.
Сериализуйте этот объект в файл. Десериализуйте объект обратно в программу из файла. Выведите все поля объекта,
включая GPA, и обсудите, почему значение GPA не было сохранено/восстановлено.
2. * Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документы).
*/

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static ru.jucharick.Journal.*;

public class Program {
    public static void main(String[] args) {
        List<Student> students;
        File f = new File(FILE_JSON);
        if (f.exists() && !f.isDirectory())
            students = loadJournalFromFile(FILE_JSON);
        else
            students = prepareStudents();
        Journal.saveJournalToFile(FILE_JSON, students);
        Journal.saveJournalToFile(FILE_BIN, students);
        Journal.saveJournalToFile(FILE_XML, students);
    }

    static List<Student> prepareStudents()
    {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Иван","Иванов", 21, 4.33));
        list.add(new Student("Петр","Петров", 18, 3.75));
        list.add(new Student("Родион","Раскольников", 27, 3.93));
        return list;
    }
}
