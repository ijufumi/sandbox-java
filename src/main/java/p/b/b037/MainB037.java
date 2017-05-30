package p.b.b037;

import java.util.*;

public class MainB037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] data = line.split(" ");
        int mm = Integer.parseInt(data[0]);
        int dd = Integer.parseInt(data[1]);

        int[] a = new int[4];
        int[] b = new int[4];
        int[] m = new int[4];
        line = sc.nextLine();
        data = line.split(" ");
        for (int i=0;i<data.length;i++) {
            a[i] = Integer.parseInt(data[i]);
        }
        line = sc.nextLine();
        data = line.split(" ");
        for (int i=0;i<data.length;i++) {
            b[i] = Integer.parseInt(data[i]);
        }
        line = sc.nextLine();
        data = line.split(" ");
        for (int i=0;i<data.length;i++) {
            m[i] = Integer.parseInt(data[i]);
        }

        int w = 0;
        int x = 0;
        int y = 0;
        int z = 0;

        String dateString = String.format("%02d%02d", mm, dd);

        int count = 0;
        for (int i=0;i<10000;i++) {
            w = (a[0] * w + b[0])%m[0];
            x = (a[1] * x + b[1])%m[1];
            y = (a[2] * y + b[2])%m[2];
            z = (a[3] * z + b[3])%m[3];

            if (check(dateString, w%10, x%10, y%10, z%10)) {
                count = i + 1;
                break;
            }
        }

        System.out.printf(String.valueOf(count));
    }

    private static boolean check(String dateString, int...num){
        StringBuilder sb = new StringBuilder(dateString);
        for (int n : num) {
            int idx = sb.indexOf(String.valueOf(n));
            if (idx == -1) {
                break;
            }
            sb.delete(idx, idx + 1);
        }

        return sb.length() == 0;
    }
}
