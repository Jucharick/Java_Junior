package ru.jucharick;

/*
Создайте абстрактный класс "Animal" с полями "name" и "age".
Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
    - Выведите на экран информацию о каждом объекте.
    - Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
*/

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Program {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Animal[] allAnimals = new Animal[5];

        allAnimals[0] = new Dog("Jack", 2, "sit down");
        allAnimals[1] = new Dog("Mack", 11, "lie down");
        allAnimals[2] = new Dog("Shurik", 3, "give me the paw");
        allAnimals[3] = new Cat("Sissy", 1, "red");
        allAnimals[4] = new Cat("Chloe", 8, "grey");


        for (int i = 0; i < allAnimals.length; i++) {
            getInfo(allAnimals[i]);
            findMethod(allAnimals[i], "makeSound");
            System.out.println();
        }
    }

    //вывод на экран информации о каждом объекте
    public static <T> void getInfo(T obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] superfields = obj.getClass().getSuperclass().getDeclaredFields(); //получаю поля класса-родителя
        Field[] fields = clazz.getDeclaredFields(); //получаю поля класса
        for (Field field : fields){
            for (Field superfield : superfields) {
                System.out.printf("Поле суперкласса: %s - %s\n", superfield.getName(), superfield.get(obj));
            }
            System.out.printf("Поле класса: %s - %s\n", field.getName(), field.get(obj));
        }
    }

    //вызов метода (например, "makeSound()")
    public static <T> void findMethod(T obj, String Method) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = obj.getClass();
        Method findMethod = clazz.getDeclaredMethod(Method);
        findMethod.invoke(obj); // вызываем на конкретном объекте
    }
}


/*
    String getName();	                Возвращает название класса
    int getModifiers();	                Возвращает модификаторы доступа
    Package getPackage();	            Возвращает информацию о пакете
    Class getSuperclass();	            Возвращает информацию о классе-родителе
    Class[] getInterfaces();	        Возвращает массив интерфейсов
    Constructor[] getConstructors();	Возвращает информацию о конструкторах класса
    Fields[] getFields();	            Возвращает поля класса
    Files getFiled(String fieldName);	Возвращает определенное поле класса по имени
    Method[] getMethods();	            Возвращает массив методов

    Метод getDeclaredFields возвращает массив объектов Field, отражающих все поля, объявленные классом
    или интерфейсом, представленным этим объектом Class.
    
    Метод getFields возвращает массив объектов Field отражающие все общедоступные (public) поля класса
    или интерфейса, представленного этим объектом Class.
    
    getModifiers                    	Получение модификаторов нашего класса
    getPackage	                        Получение пакета, в котором лежит наш класс
    getSuperclass	                    Получение суперкласса
    getInterfaces	                    Получение массива интерфейсов, которые имплементируют класс
    getName	                            Получение полного имени класса
    getSimpleName	                    Получение названия класса
*/
