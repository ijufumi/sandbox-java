package p.b.b039;

import java.util.*;

public class MainB039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int s = Integer.parseInt(sc.nextLine()) - 1;

        int[][] points = new int[n][4];
        for (int i=0;i < n;i++) {
            String[] data = sc.nextLine().split(" ");
            for (int j=0;j < 4;j++) {
                points[i][j] = Integer.parseInt(data[j]);
            }
        }

        Set<Integer> checkedSet = new HashSet<>();
        Set<Integer> sets = new HashSet<>();
        sets.add(s);
        while(true) {
            Set<Integer> tempSet = new HashSet<>();
            sets.stream().filter(x -> !checkedSet.contains(x)).forEach(x -> {
                check(tempSet, x, n, points);
                checkedSet.add(x);
            });
            if (tempSet.isEmpty()) {
                break;
            }
            sets.addAll(tempSet);
        }
        sets.stream().sorted().forEach(x -> System.out.println(x + 1));
    }

    private static void check(Set<Integer> sets, int s, int n, int[][] points) {
        int s_x0 = points[s][0];
        int s_y0 = points[s][1];

        int s_x1 = points[s][2];
        int s_y1 = points[s][1];

        int s_x2 = points[s][0];
        int s_y2 = points[s][3];

        int s_x3 = points[s][2];
        int s_y3 = points[s][3];

        for (int i=0;i < n;i++) {
            int x0 = points[i][0];
            int y0 = points[i][1];

            int x1 = points[i][2];
            int y1 = points[i][1];

            int x2 = points[i][0];
            int y2 = points[i][3];

            int x3 = points[i][2];
            int y3 = points[i][3];

            if (s_x0 >= x0 && s_x0 <= x3 &&
                    s_y0 >= y0 && s_y0 <= y3) {
                sets.add(i);
            } else if (s_x1 >= x0 && s_x1 <= x3 &&
                    s_y1 >= y0 && s_y1 <= y3) {
                sets.add(i);
            } else if (s_x2 >= x0 && s_x2 <= x3 &&
                    s_y2 >= y0 && s_y2 <= y3) {
                sets.add(i);
            } else if (s_x3 >= x0 && s_x3 <= x3 &&
                    s_y3 >= y0 && s_y3 <= y3) {
                sets.add(i);
            }
            else if (x0 >= s_x0 && x0 <= s_x3 &&
                    y0 >= s_y0 && y0 <= s_y3) {
                sets.add(i);
            } else if (x1 >= s_x0 && x1 <= s_x3 &&
                    y1 >= s_y0 && y1 <= s_y3) {
                sets.add(i);
            } else if (x2 >= s_x0 && x2 <= s_x3 &&
                    y2 >= s_y0 && y2 <= s_y3) {
                sets.add(i);
            } else if (x3 >= s_x0 && x3 <= s_x3 &&
                    y3 >= s_y0 && y3 <= s_y3) {
                sets.add(i);
            }
        }
    }
}
