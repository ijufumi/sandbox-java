package p.b.b030;

import java.util.*;

/**
 * Created by iju on 10/5/16.
 */
public class MainB030 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] data = line.split(" ");
        int h = Integer.parseInt(data[0]);
        int w = Integer.parseInt(data[1]);
        String[][] mass = new String[h][w];

        for (int i=0;i < h;i++) {
            line = sc.nextLine();
            for (int j=0;j < w;j++) {
                mass[i][j] = String.valueOf(line.charAt(j));
            }
        }
        line = sc.nextLine();
        data = line.split(" ");
        Point p = new Point();
        p.x = Integer.parseInt(data[0]) - 1;
        p.y = Integer.parseInt(data[1]) - 1;
        int n = Integer.parseInt(sc.nextLine());

        for (int i=0;i < n;i++) {
            line = sc.nextLine();
            // run(p, line);
            boolean flag = false;
            while(true) {
                run(p, line, h, w);
                switch (line) {
                    case "U":
                        if (p.y <= 0) {
                            flag = true;
                        }
                        break;
                    case "D":
                        if (p.y >= h - 1) {
                            flag = true;
                        }
                        break;
                    case "L":
                        if (p.x <= 0) {
                            flag = true;
                        }
                        break;
                    case "R":
                        if (p.x >= w - 1) {
                            flag = true;
                        }
                        break;
                    default:
                        break;
                }

                flag |= ".".equals(mass[p.y][p.x]);

                if (flag) {
                    // System.out.println(String.format("%d %d", p.x + 1, p.y + 1));
                    break;
                }
            }
        }

        System.out.println(String.format("%d %d", p.x + 1, p.y + 1));
    }

    private static void run(Point p, String c, int h, int w) {
        switch (c) {
            case "U":
                if (p.y > 0) p.y--;
                break;
            case "D":
                if (p.y < h - 1) p.y++;
                break;
            case "L":
                if (p.x > 0) p.x--;
                break;
            case "R":
                if (p.x < w - 1) p.x++;
                break;
            default:
                break;
        }
    }

    private static class Point {
        int x;
        int y;
    }
}
