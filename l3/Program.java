package home3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Program {
    // 1. Напишите программу, чтобы создать новый список массивов, добавить
    // несколько цветов (строку) и вывести коллекцию на экран.
    public static List<String> newColorList() {
        List<String> colorList = new ArrayList<>();
        colorList.add("green");
        colorList.add("red");
        colorList.add("white");
        return colorList;
    }

    // 2. Напишите программу для итерации всех элементов списка цветов и добавления
    // к каждому символа '!'.
    public static List<String> iterList(List<String> list) {
        ListIterator<String> newList = list.listIterator();
        while (newList.hasNext()) {
            newList.set(newList.next().concat("!"));
        }
        return list;
    }

    // 3. Напишите программу для вставки элемента в список массивов в первой
    // позиции.
    public static List<String> addList(List<String> list) {
        list.add(0, "yellow");
        return list;
    }

    // 4. Напишите программу для извлечения элемента (по указанному индексу) из
    // заданного списка.
    public static String getList(List<String> list) {
        return list.get(3);
    }

    // 5. Напишите программу для обновления определенного элемента массива по
    // заданному элементу.
    public static List<String> replacElement(List<String> list, String firstElement, String secondElement) {
        list.set(list.indexOf(firstElement), secondElement);
        return list;
    }

    // 6. Напишите программу для удаления третьего элемента из списка массивов.
    public static List<String> removeList(List<String> list) {
        list.remove(2);
        return list;
    }

    // 7. Напишите программу для поиска элемента в списке массивов.
    public static boolean searchElementList(List<String> list, String element) {
        if (list.contains(element))
            return true;
        else
            return false;
    }

    // 8. Напишите программу для сортировки заданного списка массивов.
    public static List<String> sortList(List<String> list) {
        Collections.sort(list);
        return list;
    }
    
    // 9. Напишите программу для копирования одного списка массивов в другой.
    public static List<String> copyList(List<String> list) {
        List<String> newCopyList = List.copyOf(list);
        return newCopyList;
    }
    
    public static void main(String[] args) {
        // 1
        System.out.println(newColorList());

        // 2
        System.out.println(iterList(newColorList()));

        // 3
        System.out.println(addList(iterList(newColorList())));

        // 4
        System.out.println(getList(addList(iterList(newColorList()))));

        // 5
        System.out.println(replacElement(addList(iterList(newColorList())), "yellow", "yellow!"));

        // 6
        System.out.println(removeList(replacElement(addList(iterList(newColorList())), "yellow", "yellow!")));

        // 7
        String serchElement = "green!";
        System.out.println(searchElementList(removeList(replacElement(addList(iterList(newColorList())), "yellow", "yellow!")), serchElement));

        // 8
        System.out.println(sortList(removeList(replacElement(addList(iterList(newColorList())), "yellow", "yellow!"))));

        // 9
        System.out.println(copyList(sortList(removeList(replacElement(addList(iterList(newColorList())), "yellow", "yellow!")))));
    }
}

