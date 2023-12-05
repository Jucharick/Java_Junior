package ru.jucharick;

public class Dog extends Animal {
    //region Конструкторы
    public Dog(String name, int age, String commands) {
        super(name, age);
        this.commands = commands;
    }
    //endregion

    //region Методы
    @Override
    public String toString() {
        return "Dog {" +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void makeSound() {
        System.out.println("Woof Woof Woof");
    }
    //endregion

    //region Поля
    /**
     * Команды
     */
    protected String commands;
    //endregion
}
