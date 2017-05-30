package p.b.b023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainB023 {
    private static final Map<Character, Character[][]> CONV_MAP = new HashMap<>();
    static {
        CONV_MAP.put('0', new Character[][]{{}, {'6', '9'}, {'8'}});
        CONV_MAP.put('1', new Character[][]{{}, {}, {'7'}});
        CONV_MAP.put('2', new Character[][]{{}, {'3'}, {}});
        CONV_MAP.put('3', new Character[][]{{}, {'2', '5'}, {'9'}});
        CONV_MAP.put('4', new Character[][]{{}, {}, {}});
        CONV_MAP.put('5', new Character[][]{{}, {'3'}, {'6', '9'}});
        CONV_MAP.put('6', new Character[][]{{'5'}, {'0', '9'}, {'8'}});
        CONV_MAP.put('7', new Character[][]{{'1'}, {}, {}});
        CONV_MAP.put('8', new Character[][]{{'0', '6', '9'}, {}, {}});
        CONV_MAP.put('9', new Character[][]{{'3', '5'}, {'0', '6'}, {'8'}});
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Set<String> resultList = new HashSet<>();
        for (int i=0;i < line.length();i++) {
            char val = line.charAt(i);
            resultList.addAll(makeNumber(i, val, line));
        }

        List<String> answersList = new ArrayList<>(resultList);
        Collections.sort(answersList);
        for (String s : answersList) {
            System.out.println(s);
        }
        if (answersList.isEmpty()) {
            System.out.println("none");
        }
    }

    private static Set<String> makeNumber(int idx, char val, String numbers) {
        Character[][] checkVals = CONV_MAP.get(val);
        Set<String> numberList = new HashSet<>();
        if (checkVals[0].length != 0) {
            for (char c : checkVals[0]) {
                for (int i=0;i < numbers.length();i++) {
                    if (i == idx) {
                        continue;
                    }
                    char otherVal = numbers.charAt(i);
                    if (CONV_MAP.get(otherVal)[2].length != 0) {
                        for (char c2 : CONV_MAP.get(otherVal)[2]) {
                            numberList.add(new StringBuilder(numbers)
                                    .replace(idx, idx + 1, String.valueOf(c))
                                    .replace(i, i + 1, String.valueOf(c2))
                                    .toString()
                            );
                        }
                    }
                }
            }
        }
        if (checkVals[1].length != 0) {
            for (char c : checkVals[1]) {
                numberList.add(new StringBuilder(numbers)
                        .replace(idx, idx + 1, String.valueOf(c))
                        .toString()
                );
            }
        }
        if (checkVals[2].length != 0) {
            for (char c : checkVals[2]) {
                for (int i=0;i < numbers.length();i++) {
                    if (i == idx) {
                        continue;
                    }
                    char otherVal = numbers.charAt(i);
                    if (CONV_MAP.get(otherVal)[0].length != 0) {
                        for (char c2 : CONV_MAP.get(otherVal)[0]) {
                            numberList.add(new StringBuilder(numbers)
                                    .replace(idx, idx + 1, String.valueOf(c))
                                    .replace(i, i + 1, String.valueOf(c2))
                                    .toString()
                            );
                        }
                    }
                }
            }
        }
        return numberList;
    }
}
