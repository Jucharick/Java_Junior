package ru.jucharick;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Journal {
    //region Поля
    public static final String FILE_JSON = "students_journal.json";
    public static final String FILE_BIN = "students_journal.bin";
    public static final String FILE_XML = "students_journal.xml";

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();
    //endregion

    //region Методы
    public static void saveJournalToFile(String fileName, List<Student> students) {
        try {
            if (fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), students);
            } else if (fileName.endsWith(".bin")) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    oos.writeObject(students);
                }
            } else if (fileName.endsWith(".xml")) {
                xmlMapper.writeValue(new File(fileName), students);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> loadJournalFromFile(String fileName) {
        List<Student> students = new ArrayList<>();

        File file = new File(fileName);
        if (file.exists()) {
            try {
                if (fileName.endsWith(".json")) {
                    students = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
                } else if (fileName.endsWith(".bin")) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                        students = (List<Student>) ois.readObject();
                    }
                } else if (fileName.endsWith(".xml")) {
                    students = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    public static void displayJournal(List<Student> students) {
        System.out.println("Список студентов:");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println((i + 1) + ".  Имя: " + student.getName() +
                                         " Фамилия: " + student.getSurname() +
                                         " Возраст: " + student.getAge() +
                                         " Средний балл: " + student.getGPA());
        }
    }
    //endregion
}
