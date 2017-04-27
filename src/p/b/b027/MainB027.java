package p.b.b027;

import java.util.*;

public class MainB027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] data = line.split(" ");
        int h = Integer.parseInt(data[0]);
        int w = Integer.parseInt(data[1]);
        int n = Integer.parseInt(data[2]);
        int[][] cards = new int[h][w];
        for (int i=0;i < h;i++) {
            line = sc.nextLine();
            data = line.split(" ");
            for (int j=0;j < w;j++) {
                cards[i][j] = Integer.parseInt(data[j]);
            }
        }

        int[] player = new int[n];
        int idx = 0;

        int l = Integer.parseInt(sc.nextLine());

        for (int i=0;i < l;i++) {
            line = sc.nextLine();
            data = line.split(" ");
            int x1 = Integer.parseInt(data[0]) - 1;
            int y1 = Integer.parseInt(data[1]) - 1;
            int x2 = Integer.parseInt(data[2]) - 1;
            int y2 = Integer.parseInt(data[3]) - 1;

            if (cards[x1][y1] == cards[x2][y2]) {
                player[idx] += 2;
            }
            else {
                idx++;
                if (idx == n) {
                    idx = 0;
                }
            }
        }

        for (int i=0;i < n;i++) {
            System.out.println(player[i]);
        }
    }
}
