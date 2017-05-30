package p.a.a006;

import java.util.*;
/**
 * Created by iju on 10/27/16.
 */
public class MainA006 {

    static Set<Point> markedCell = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Point[] now = new Point[n];
        for (int i=0;i < n;i++) {
            String[] rec = sc.nextLine().split(" ");
            now[i] = new Point();
            now[i].x = Integer.parseInt(rec[0]);
            now[i].y = Integer.parseInt(rec[1]);
            markedCell.add(now[i].copy());
        }

        int times = 0;
        int diff = 0;
        int turn = 0;
        int max = 1;
        int maxCnt = 0;
        int d = 1;
        while(true) {
            times++;
            diff++;
            int c = move(now, d);
            if (c == 0) {
                times--;
                break;
            }
            // System.out.println(max);
            if (diff == max) {
                turn++;
                diff = 0;
                maxCnt++;
                if (maxCnt == 2) {
                    max++;
                    maxCnt = 0;
                }
                switch (d) {
                    case 1:
                        d = 2;
                        break;
                    case 2:
                        d = 3;
                        break;
                    case 3:
                        d = 0;
                        break;
                    case 0:
                        d = 1;
                        break;
                }
            }
        }
        System.out.println(times);
    }

    static int move(Point[] now, int d) {
        int c = 0;
        for (int i=0;i < now.length;i++) {
            if (now[i] == null) {
                continue;
            }
            switch (d) {
                case 1:
                    now[i].x += 1;
                    break;
                case 2:
                    now[i].y -= 1;
                    break;
                case 3:
                    now[i].x -= 1;
                    break;
                case 0:
                    now[i].y += 1;
                    break;
            }
            if (markedCell.contains(now[i])) {
                // System.out.println(now[i]);
                now[i] = null;
            } else {
                c++;
                markedCell.add(now[i].copy());
            }
        }
        return c;
    }

    static class Point {
        int x;
        int y;

        public boolean equals(Object o) {
            if (o == null || !(o instanceof Point)) {
                return false;
            }

            Point p = (Point) o;

            return p.x == x && p.y == y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }

        public String toString() {
            return String.format("x:%d, y:%d", x, y);
        }

        public Point copy() {
            Point p = new Point();
            p.x = x;
            p.y = y;

            return p;
        }
    }
}
