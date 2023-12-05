package ru.jucharick;

public class Cat extends Animal {
    //region Конструкторы
    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    //endregion

    //region Методы
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Cat {" +
                "name='" + name + '\'' +
                ", age=" + age +
                "color='" + color + '\'' +
                '}';
    }

    @Override
    public void makeSound() {
        System.out.println("Meow Meow Meow");
    }
    //endregion

    //region Поля
    /**
     * Окрас
     */
    protected String color;
    //endregion
}
