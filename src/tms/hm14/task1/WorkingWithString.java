package tms.hm14.task1;
/**
 * Программа обрабатывает список студентов
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class WorkingWithString {

    public static void main(String[] args) {
        ArrayList<String> arrayNum = new ArrayList<>();

        arrayNum.add("Svetlana");
        arrayNum.add("Anton");
        arrayNum.add("Vitalij");
        arrayNum.add("Tasja");
        arrayNum.add("Aleksander");
        arrayNum.add("Julia");
        arrayNum.add("Vitalij");
        arrayNum.add("Mary");
        arrayNum.add("Lera");
        arrayNum.add("Egor");
        arrayNum.add("Aina");
        arrayNum.add("Anatolij");
        arrayNum.add("Olga");
        arrayNum.add("Katharina");
        arrayNum.add("Maria");

        Stream<String> streamFromArrayList = arrayNum.stream();//создание коллекции
        System.out.println("Исходный массив: " + arrayNum.toString());

        Scanner in = new Scanner(System.in);
        System.out.println("Выберите действие с массивом:\n" +
                "1 - вывести количество имен Svetlana;\n" +
                "2 - вывести слова на букву а;\n" +
                "3 - отсортировать и вывести первое имя;\n" +
                "0 - не выполнять никаких действий и выйти из программы.");
        String flag = in.next();

        Stream<String> a = Stream.of("");
        if (flag.equals("1")){
            System.out.println("Количество имен Svetlana");
            System.out.println(streamFromArrayList.filter((s) -> s.equalsIgnoreCase("svetlana"))
                    .count());
        }else if (flag.equals("2")){
            System.out.println("Выбирает имена на букву а");
            streamFromArrayList.filter((s) -> s.substring(0, 1).equalsIgnoreCase("a"))
                    .forEach(System.out::println);
        }else if (flag.equals("3")){
            System.out.println("Сортируем и возвращаем первый элемент");
            streamFromArrayList.sorted().limit(1).forEach(System.out::println);
        }else if (flag.equals("0")){
            System.out.println("Вы решили завершить выполнение программы.");
        }else {
            System.out.println("Для данного номера не предусмотрено действие.");
        }

        in.close();
    }

}
