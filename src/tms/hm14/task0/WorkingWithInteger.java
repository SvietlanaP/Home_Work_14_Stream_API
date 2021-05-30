package tms.hm14.task0;
/**
 * Программа обрабатывает числовой массив
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class WorkingWithInteger {

    public static void main(String[] args) {
        ArrayList<Integer> arrayNum = new ArrayList<>();

        int sizeArray = 5;

        for (int i = 0; i <= sizeArray; i++){//создаем ArrayList
            arrayNum.add((int) (Math.random() * 20));
        }

        Stream<Integer> streamFromArrayList = arrayNum.stream();//создание коллекции
        System.out.println("Исходный массив: " + arrayNum.toString());

        Scanner in = new Scanner(System.in);
        System.out.println("Выберите действие с массивом:\n" +
                "1 - удалить дубликаты;\n" +
                "2 - вывести четные числа из диапазона 7-17;\n" +
                "3 - умножить элементы на 2;\n" +
                "4 - отсортировать и вывести первые 4 элемента;\n" +
                "5 - посчитать количество элементов;\n" +
                "6 - посчитать сренеарифметическое;\n" +
                "0 - не выполнять никаких действий и выйти из программы.");
        String flag = in.next();

        if (flag.equals("1")){
            System.out.println("Удаляем дубликаты");
            streamFromArrayList.distinct()
                    .forEach(System.out::println);
        } else if (flag.equals("2")){
            System.out.println("Выводим четные диапазона 7-17");
            streamFromArrayList.filter((s) -> (s>7) && (s<17) && (s % 2 ==0))
                    .forEach(System.out::println);
        } else if (flag.equals("3")){
            System.out.println("Умножаем все на 2");
            streamFromArrayList.map((s) -> 2*s)
                    .forEach(System.out::println);
        }else if (flag.equals("4")){
            System.out.println("Сортируем и выводим 4 первых элемента");
            streamFromArrayList.sorted().limit(4)
                    .forEach(System.out::println);
        }else if (flag.equals("5")){
            System.out.println("Количество элементов");
            System.out.println(streamFromArrayList.count());
        }else if (flag.equals("6")){
            System.out.println("Считает среднеарифметическое");
            System.out.println(streamFromArrayList.mapToInt(Integer::intValue).average());
        } else if (flag.equals("0")){
            System.out.println("Вы решили завершить выполнение программы.");
        }else {
            System.out.println("Для данного номера не предусмотрено действие.");
        }

        in.close();


    }

}
