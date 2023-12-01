package ru.jucharick;

/*
Напишите программу, которая использует Stream API для обработки списка чисел.
Программа должна вывести на экран среднее значение всех четных чисел в списке.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Program {
    public final static Random random = new Random();

    public static void main(String[] args) {
        List<Integer> randomNumbers = createListIntNumber(10);
        System.out.println("Создан список: ");
        System.out.println(randomNumbers);

        // Поиск всех четных чисел
        List<Integer> evenNumbers = randomNumbers.stream()
                .filter(number -> number % 2 == 0).toList();

        System.out.println("Четные числа: ");
        System.out.println(evenNumbers);

        // Поиск среднего значения всех четных чисел
        double average = evenNumbers.stream()
                .mapToInt(i -> i)
                .average().orElse(0);
        System.out.printf("Среднее значение: %f", average);

        //Для использования метода average нужно Stream<Integer> привести к IntStream:
        //average() - возвращает необязательный параметр, описывающий среднее значение
        //элементов в потоке, или пустой необязательный параметр, если поток пуст
    }

    public static List<Integer> createListIntNumber(int listLength) {
        List<Integer> randomNumbers = new ArrayList<>(listLength);
        for (int i = 0; i < listLength; i++) {
            randomNumbers.add(random.nextInt(100));
        }
        return randomNumbers;
    }
}
