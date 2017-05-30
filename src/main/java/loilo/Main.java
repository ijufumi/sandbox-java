package loilo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/**
 * topPosition
 * nowPosition
 * seekPosition
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        System.out.println(calculate(line));
    }

    public static List<String> calculate(String line) {
        if (line == null || line.length() == 0) {
            return Collections.emptyList();
        }

        List<String> answerList = new ArrayList<>();
        answerList.add(line);
        swap(line, answerList);
        return answerList;
    }

    private static void swap(String line, List<String> answerList) {
        for (int i=0;i < line.length() - 1;i++) {
            for (int j=i + 1;j < line.length();j++) {
                String value = swap(line, i, j);
                if (!answerList.contains(value)) {
                    answerList.add(value);
                    swap(value, answerList);
                }
            }
        }
    }

    private static String swap(String line, int from, int to) {
        char[] charArray = line.toCharArray();

        char temp = charArray[to];
        charArray[to] = charArray[from];
        charArray[from] = temp;

        return new String(charArray);
    }
}
