package home5;

import java.util.HashMap;
import java.util.Map;

public class Program {
    public static void main(String[] args) {
        // 1. Объявить и инициализировать словарь hashMap<String, String>
        Map<String, String> javaLessonsMap = new HashMap<>();
        System.out.println(
                "Задание №1\nИнициализируем словарь в котором будут храниться номра и темы уроков по курсу \"Знакомство с JAVA\"");
        System.out.println();

        // 2. Добавить в словарь 10 пар "Ключ - Значение". Автор и название книги
        // например.
        System.out.println("Задание №2\nНаполняем словарь информацией:");
        javaLessonsMap.put("Урок 1", "Знакомство с языком программирования Java");
        javaLessonsMap.put("Урок 2", "Почему вы не можете не использовать API");
        javaLessonsMap.put("Урок 3", "Коллекции JAVA: Введение");
        javaLessonsMap.put("Урок 4", "Хранение и обработка данных ч1: приоритетные коллекции");
        javaLessonsMap.put("Урок 5", "Хранение и обработка данных ч2: множество коллекций Map");
        javaLessonsMap.put("Урок 6", "Хранение и обработка данных ч3: множество коллекций Set");
        javaLessonsMap.put("Урок 7", "Введение в ООП. Свои типы и концепты");
        javaLessonsMap.put("Урок 8", "Принципы ООП Абстракция и интерфейсы. Пример проектирования");
        javaLessonsMap.put("Урок 9", "Некоторые стандартные интерфейсы Java и примеры их использования");
        javaLessonsMap.put("Урок 10", "ООП: Обобщения");
        javaLessonsMap.forEach((a, b) -> System.out.println("Номер урока: " + a + ". Тема урока: " + b));
        System.out.println();

        // 3. Пройти по словарю и добавить к значениям символ "!"
        System.out.println("Задание №3\nПридаем эмоциональную окраску темам уроков:");
        javaLessonsMap.replaceAll((a, b) -> b + "!");
        javaLessonsMap.forEach((a, b) -> System.out.println("Номер урока: " + a + ". Тема урока (с изумлением): " + b));
        System.out.println();

        // 4. Добавить нового автора и название книги если соответствующего ключа не
        // было.
        System.out.println("Задание №4\nДобавляем 11 урок и его тему в словарь:");
        javaLessonsMap.computeIfAbsent("Урок 11", b -> getNewValue());
        javaLessonsMap.forEach((a, b) -> System.out.println("Номер урока: " + a + ". Тема урока (с изумлением): " + b));
        System.out.println();

        // 5. Если ключ, указанный в запросе, имеется, вырезать из соответствующего
        // ключу значения первое слово.
        System.out.println("Задание №5\nУдаляем слово \"Знакомство\" из темы первого урока:");
        javaLessonsMap.computeIfPresent("Урок 1", (a, b) -> b.replaceFirst("Знакомство", ""));
        javaLessonsMap.forEach((a, b) -> System.out.println("Номер урока: " + a + ". Тема урока (с изумлением): " + b));
        System.out.println();

        // 7. ** Пройти по словарю другим, не таким как в пункте 3 и 6, методом.
        // Добавить к значениям строку "(просмотрен)" и вывести в консоль.
        System.out.println(
                "Задание №7\nИнтересным методом добавляем слово \"Просмотрен\" к теме второго урока (после знака выражающего изумление):");
        javaLessonsMap.compute("Урок 2", (a, b) -> b + " Просмотрен");
        javaLessonsMap.forEach((a, b) -> System.out.println("Номер урока: " + a + ". Тема урока (с изумлением): " + b));
        System.out.println();
    }

    // 4
    public static String getNewValue() {
        return "ООП: От простого к практике!";
    }

    // 6. *Пройти по словарю другим, не таким как в пункте 3, методом и вывести пары
    // ключ значение в консоль.
}
