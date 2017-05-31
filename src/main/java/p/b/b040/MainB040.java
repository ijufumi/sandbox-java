package p.b.b040;

import java.util.*;

public class MainB040 {

    private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        String[] data = line.split(" ");
        int n = Integer.parseInt(data[0]);
        char[] charArray = sc.nextLine().toCharArray();

        for (int i=0;i < n;i++) {
            decryption(charArray, data[1]);
        }
        System.out.println(new String(charArray));
    }

    private static void decryption(char[] charArray, String key) {
        for (int i=0;i < charArray.length;i++) {

            char c = charArray[i];
            int idx = key.indexOf(c);
            if (idx < 0) {
                continue;
            }
            char newC = ALPHA.charAt(idx);
            charArray[i] = newC;
        }
    }
}
