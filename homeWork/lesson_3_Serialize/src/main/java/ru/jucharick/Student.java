package ru.jucharick;

import java.beans.Transient;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

public class Student implements Externalizable {
    //region Поля
    /**
     * Имя студента
     */
    private String name;

    /**
     * Фамилия студента
     */
    private String surname;

    /**
     * Возраст
     */
    private int age;

    /**
     * Средний балл
     */
    private  double gpa;
    //endregion

    //region Конструкторы
    public Student(String name, String surname, int age, double gpa) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gpa = gpa;
    }

    public Student() {
    }
    //endregion

    //region Методы
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return gpa;
    }
    //endregion

    //region Externalizable implementation
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(surname);
        out.writeInt(age);
        out.writeDouble(gpa);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        surname = (String) in.readObject();
        age = in.readInt();
        gpa = in.readDouble();
    }
    //endregion
}
