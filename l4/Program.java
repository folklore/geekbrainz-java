package home4;

import java.util.LinkedList;
import java.util.List;

public class Program {
    // 1. Объявить и инициализировать связанный список в 10000 элементов случайным
    // числом от -1024 до 1024
    public static List<Integer> randomLinkedList(int max, int min, int sizeList) {
        List<Integer> randList = new LinkedList<>();
        while (randList.size() <= sizeList) {
            randList.add((int) (Math.random() * ((max - min) + 1)) + min);
        }
        return randList;
    }

    // 2. Пройти по списку и удалить все отрицательные элементы
    public static List<Integer> removeNegativeElement(List<Integer> list) {
        list.removeIf(s -> s < 0);
        return list;
    }

    // 3. Скопировать в переменные и удалить из списка первый и второй элементы,
    // сложить переменные, результат сохранить в начало списка.
    public static List<Integer> firstPlusSecondElement(List<Integer> list) {
        int first = list.remove(0); // метод remove возвращает удаленный элемент в перемнную first
        int second = list.remove(0);
        list.add(0, first + second);
        return list;
    }

    // 4. Реализовать пункт №3 для всего списка.
    public static List<Integer> sumElementList(List<Integer> list) {
        while (list.size() > 1) {
            firstPlusSecondElement(list);
        }
        return list;
    }

    
    public static void main(String[] args) {
        // 1
        int max = 1024, min = -1024, sizeList = 10_000;
        long start = System.currentTimeMillis();
        List<Integer> randomList = randomLinkedList(max, min, sizeList);
        long finish = System.currentTimeMillis();
        System.out.println(randomList);
        System.out.println(String.format("Время выполнения функции 'randomLinkedList': %s msc", (finish - start)));
        
        // 2
        start = System.currentTimeMillis();
        List<Integer> positiveList = removeNegativeElement(randomList);
        finish = System.currentTimeMillis();
        System.out.println(positiveList);
        System.out.println(String.format("Время выполнения функции 'removeNegativeElement': %s msc", (finish - start)));
        
        // 3
        start = System.currentTimeMillis();
        List<Integer> updatedList = firstPlusSecondElement(positiveList);
        finish = System.currentTimeMillis();
        System.out.println(updatedList);
        System.out.println(String.format("Время выполнения функции 'firstPlusSecondElement': %s msc", (finish - start)));

        // 4
        start = System.currentTimeMillis();
        List<Integer> sumList = sumElementList(updatedList);
        finish = System.currentTimeMillis();
        System.out.println(sumList);
        System.out.println(String.format("Время выполнения функции 'sumElementList': %s msc", (finish - start)));
    }
    
    // 5. Измерить время исполнения пунктов №2 и №3.
    // 6. *Реализовать пункты с первого по пятый но с ArrayList. Сравнить время
    // исполнения.
    // 7. **Оптимизировать реализацию заданий так, чтобы время выполнения LinkedList
    // и ArrayList были наименьшим.
}
