package p.b.b032;

import java.util.*;
/**
 * Created by iju on 10/5/16.
 */
public class MainB032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int w = Integer.parseInt(line);

        String[][] a1 = new String[8][w];
        for (int i=0; i < 8;i++) {
            line = sc.nextLine();
            for (int j=0;j < w;j++) {
                a1[i][j] = String.valueOf(line.charAt(j));
            }
        }

        String[][] a2 = new String[8][w];
        for (int i=0; i < 8;i++) {
            line = sc.nextLine();
            for (int j=0;j < w;j++) {
                a2[i][j] = String.valueOf(line.charAt(j));
            }
        }

        long v1 = toInt(a1, w);
        long v2 = toInt(a2, w);

        long v3 = v1 + v2;

        //System.out.println(String.format("%d+%d=%d", v1, v2, v3));

        String[][] a3 = toStrArray(v3, w);

        for (int i=0;i < 8;i++) {
            for (int j=0;j < w;j++) {
                System.out.print(a3[i][j]);
            }
            System.out.println();
        }
    }

    private static long toInt(String[][] a, int w) {
        long ans = 0;
        for (int j = w - 1;j >= 0;j--) {
            long tmp = 0;
            if (a[1][j].equals("*")) {
                tmp = 5;
            }
            for (int i=3;i < 8;i++) {
                if (a[i][j].equals("|")) {
                    break;
                }
                tmp += 1;
            }
            ans += tmp * Math.pow(10, w - j - 1);
        }
        return ans;
    }

    private static String[][] toStrArray(long a, int w) {
        String[][] ans = new String[8][w];
        long num = a;
        for (int i=0;i < w;i++) {
            long v1 = num/(long)Math.pow(10, w - i - 1);
            num -= v1 * (long)Math.pow(10, w - i - 1);
            if (v1 >= 5) {
                ans[0][i] = "|";
                ans[1][i] = "*";
            }
            else {
                ans[0][i] = "*";
                ans[1][i] = "|";
            }
            ans[2][i] = "=";

            long v2 = (v1 >= 5) ? (v1 - 5) : v1;

            //System.out.println(v2);

            int c = 0;
            for (int j=3;j < 8;j++) {
                if (c == v2) {
                    // System.out.println(j);
                    break;
                }
                ans[j][i] = "*";
                c++;
            }
            //System.out.println(v2);
            //System.out.println(c);
            ans[3+c][i] = "|";
            //System.out.println(c);
            for (int j=3 + c + 1;j < 8;j++) {
                ans[j][i] = "*";
            }

        }

        return ans;
    }
}
