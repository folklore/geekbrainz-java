package home1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Program {

    // 1 Выбросить случайное целое число и сохранить в i
    public static int randomNum(int min, int max) {
        int num = (int) (Math.random() * ((max - min) + 1)) + min;
        return num;
    }

    // 2 Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
    public static int seniorBit(int i) {
        int binLen = Integer.toBinaryString(i).length();
        return binLen;
    }

    // 3 Найти все кратные n числа большие i и сохранить в массив m1
    public static ArrayList<Integer> arrayMult(int i, int n, int max) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int j = i + 1; j <= max; j++) {
            if (j % n == 0) {
                list.add(j);
            }
        }
        return list;
    }

    // 4 Найти все некратные n числа меньшие i и сохранить в массив m2
    public static ArrayList<Integer> arrayNotMult(int i, int n, int min) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int j = i - 1; j >= min; j--) {
            if (j % n != 0) {
                list.add(j);
            }
        }
        return list;
    }

    // 5 Сохранить оба массива в файлы с именами m1 и m2 соответственно.
    public static void saveArray(ArrayList<Integer> arr, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Integer c : arr) {
                writer.write(c + "\t");
                // writer.write(System.getProperty("line.separator")); // построчная запись
            }
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int min = 1, max = 10_000;
        int i = randomNum(min, max);
        System.out.println("integer between " + min + " and " + max + ": i = " + i);
        int n = seniorBit(i);
        System.out.println("number of the senior bit from i: n = " + n);
        ArrayList<Integer> m1 = arrayMult(i, n, max);
        // System.out.print("array values multiple n > i: " + m1);
        ArrayList<Integer> m2 = arrayNotMult(i, n, min);
        // System.out.print("array values not multiple n < i: " + m2);
        saveArray(m1, "home1/m1.txt");
        saveArray(m2, "home1/m2.txt");
    }
}