package p.b.b038;

import java.util.*;

public class MainB038 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] data = line.split(" ");
        int a = Integer.parseInt(data[0]);
        int b = Integer.parseInt(data[1]);
        int c = Integer.parseInt(data[2]);
        int d = Integer.parseInt(data[3]);

        boolean isMiss = false;
        int k = 0;
        for (int i=1;i<b;i++) {
            if (c*i + d*b - d*i - a == 0) {
                if (k == 0) {
                    k = i;
                }
                else {
                    isMiss = true;
                    break;
                }
            }
        }

        if (isMiss || k == 0) {
            System.out.println("miss");
        }
        else {
            System.out.println(String.format("%d %d", k, b - k));
        }
    }
}
