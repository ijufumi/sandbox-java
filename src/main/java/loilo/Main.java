package loilo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/**
 * 与えられた文字列を入れ替えて、全てのパターンを生成するプログラム。
 * 例えば、
 * input : abc
 * output : abc acb bac bca cab cba
 * となるようなもの。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        System.out.println(makeString(line));
    }

    /**
     * 文字を入れ替えて全てのパターンを生成する。
     * 入れ替えの再帰呼び出しを行うので、7文字以上だと遅くなってしまう。
     *
     * @param line
     * @return
     */
    public static List<String> swap(String line) {
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

    /**
     * ある1文字を今ある文字列の各位置に挿入して全てのパターンを生成する。
     * 再帰呼び出しがないので、10文字でも実行可能。
     *
     * @param line
     * @return
     */
    public static List<String> makeString(String line) {
        if (line == null || line.length() == 0) {
            return Collections.emptyList();
        }

        List<String> stringList = new ArrayList<>();
        stringList.add(line.substring(0, 1));
        for (int i=1;i < line.length();i++) {
            stringList = makeString(line.charAt(i), stringList);
        }

        return stringList;
    }

    private static List<String> makeString(char ch, List<String> baseString) {
        List<String> stringList = new ArrayList<>();

        for (String str : baseString) {
            for (int i=0;i < str.length();i++) {
                stringList.add(new StringBuilder(str).insert(i, ch).toString());
            }
            stringList.add(str + ch);
        }

        return stringList;
    }
}
