package p.b.b033;

import java.util.*;

public class MainB033 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = Integer.parseInt(sc.nextLine());
        String[] header = sc.nextLine().split(" ");
        int n = Integer.parseInt(sc.nextLine());
        String[][] data = new String[n + 1][w];

        int[] size = new int[w];
        for (int i=0;i < w;i++) {
            data[0][i] = header[i];
            size[i] = data[0][i].length();
        }

        for (int i=0;i < n;i++) {
            String[] rec = sc.nextLine().split(" ");
            for (int j=0;j < w;j++) {
                data[i + 1][j] = rec[j];

                int size2 = data[i + 1][j].length();
                if (size[j] < size2) {
                    size[j] = size2;
                }
            }
        }

        for (int i=0;i < n + 1;i++) {
            StringBuilder sb = new StringBuilder("");
            for (int j=0;j < w;j++) {
                sb.append("| ");
                sb.append(data[i][j]);
                sb.append(String.format("%" + (size[j] + 1 - data[i][j].length()) + "s", ""));
            }
            sb.append("|");
            System.out.println(sb.toString());
            if (i == 0) {
                sb.delete(0, sb.length());
                for (int j=0;j < w;j++) {
                    sb.append("|");
                    for (int k=0;k < size[j] + 2;k++) {
                        sb.append("-");
                    }
                }
                sb.append("|");
                System.out.println(sb.toString());
            }
        }
    }
}
