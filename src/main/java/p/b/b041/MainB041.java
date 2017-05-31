package p.b.b041;

import java.util.*;

public class MainB041 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        char[][] mass = new char[n][];

        for (int i = 0;i < n;i++) {
            String line = sc.nextLine();
            mass[i] = line.toCharArray();
        }

        //output(mass);
        for (int i=0;i < k;i++) {
            mass = expand(mass);
            //output(mass);
        }

        output(mass);
    }

    private static void output(char[][] charArray) {
        for (int i=0;i < charArray.length;i++) {
            System.out.println(new String(charArray[i]));
        }
    }

    private static char[][] expand(char[][] charArray) {
        int size = charArray.length;
        int newSize = size * size;
        char[][] newCharArray = new char[newSize][newSize];

        //for (int i=0;i < newSize;i++) {
        //    Arrays.fill(newCharArray[i], 0, newSize, '*');
        //}

        for (int i=0;i < size;i++) {
            char[] chars = charArray[i];
            for (int j=0;j < size;j++) {
                char c = chars[j];
                if (c == '#') {
                    for (int k=0;k < size;k++) {
                        System.arraycopy(charArray[k], 0, newCharArray[k + i * size], j * size, size);
                    }
                    //output(newCharArray);
                }
                else {
                    for (int k=0;k < size;k++) {
                        Arrays.fill(newCharArray[k + i * size], j * size, j* size + size, '.');
                    }
                    //output(newCharArray);
                }
            }
        }
        return newCharArray;
    }
}
