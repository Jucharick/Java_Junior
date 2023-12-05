package ru.jucharick;

public abstract class Animal {
    //region Конструкторы
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //endregion

    //region Методы
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void makeSound(){

    }

    @Override
    public String toString() {
        return "Animal {" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    //endregion

    //region Поля
    /**
     * Имя
     */
    protected String name;
    /**
     * Возраст
     */
    protected int age;
    //endregion
}
