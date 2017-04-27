package p.a.a014;

import java.util.*;

/**
 * Created by iju on 2017/04/27.
 */
public class MainA014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] data = line.split(" ");

        int x = Integer.parseInt(data[0]);
        int y = Integer.parseInt(data[1]);
        int n = Integer.parseInt(data[2]);

        String[][] cards = new String[x][];

        for (int i=0;i < x;i++) {
            cards[i] = sc.nextLine().split(" ");
        }

        List<String> ans = new ArrayList<>();
        for (int i=0;i < n;i++) {
            String[] rec = sc.nextLine().split(" ");
            int x1 = Integer.parseInt(rec[0]) - 1;
            int y1 = Integer.parseInt(rec[1]) - 1;
            int x2 = Integer.parseInt(rec[2]) - 1;
            int y2 = Integer.parseInt(rec[3]) - 1;

            if(check(x1, y1, x2, y2, cards, x - 1, y - 1)) {
                ans.add("yes");
            }
            else {
                ans.add("no");
            }
        }

        for (String s : ans) {
            System.out.println(s);
        }
    }

    private static boolean check(int x1, int y1, int x2, int y2, String[][] cards, int x, int y) {
        // 文字が違う場合
        if (!cards[x1][y1].equals(cards[x2][y2])) {
            return false;
        }

        // 隣り合う場合
        if (x1 == x2 && ((y1 - 1 == y2) || (y1 + 1 == y2))) {
            return true;
        }

        if (y1 == y2 && ((x1 - 1 == x2) || (x1 + 1 == x2))) {
            return true;
        }

        // x もしくは yが同じ場合
        if (x1 == 0 && x1 == x2) {
            return true;
        }
        if (x1 == x && x1 == x2) {
            return true;
        }
        if (y1 == 0 && y1 == y2) {
            return true;
        }
        if (y1 == y && y1 == y2) {
            return true;
        }

        // 中を通る場合(xもしくはyが同じ）
        int diffX = (x1 > x2) ? -1 : 1;
        int diffY = (y1 > y2) ? -1 : 1;
        if (x1 == x2) {
            if (x1 > 0) {
                int idx = 1;
                int nextX = x1 - 1;
                while  (true) {
                    int nextY = y1 + diffY * idx;
                    if (nextY < 0 || nextY > y) {
                        // System.out.println(String.format("[A] x : %d, y : %d", nextX, y1));
                        return false;
                    }
                    if (nextY == y2) {
                        break;
                    }
                    if (!cards[nextX][nextY].equals(".")) {
                        // System.out.println(String.format("[B] x : %d, y : %d", nextX, y1));
                        return false;
                    }
                    idx++;
                }
                return true;
            }
            if (x1 < x) {
                int idx = 1;
                int nextX = x1 + 1;
                while  (true) {
                    int nextY = y1 + diffY * idx;
                    if (nextY < 0 || nextY > y) {
                        // System.out.println(String.format("[A] x : %d, y : %d", nextX, y1));
                        return false;
                    }
                    if (nextY == y2) {
                        break;
                    }
                    if (!cards[nextX][nextY].equals(".")) {
                        // System.out.println(String.format("[B] x : %d, y : %d", nextX, y1));
                        return false;
                    }
                    idx++;
                }
                return true;
            }
        }
        else if (y1 == y2) {
            if (y1 > 0) {
                int idx = 1;
                int nextY = y1 - 1;
                while  (true) {
                    int nextX = x1 + diffY * idx;
                    if (nextX < 0 || nextX > x) {
                        // System.out.println(String.format("[A] x : %d, y : %d", nextX, y1));
                        return false;
                    }
                    if (nextX == x2) {
                        break;
                    }
                    if (!cards[nextX][nextY].equals(".")) {
                        // System.out.println(String.format("[B] x : %d, y : %d", nextX, y1));
                        return false;
                    }
                    idx++;
                }
                return true;
            }
            if (y1 < y) {
                int idx = 1;
                int nextY = y1 + 1;
                while  (true) {
                    int nextX = x1 + diffY * idx;
                    if (nextX < 0 || nextX > x) {
                        // System.out.println(String.format("[A] x : %d, y : %d", nextX, y1));
                        return false;
                    }
                    if (nextX == x2) {
                        break;
                    }
                    if (!cards[nextX][nextY].equals(".")) {
                        // System.out.println(String.format("[B] x : %d, y : %d", nextX, y1));
                        return false;
                    }
                    idx++;
                }
                return true;
            }
        }

        // 中を通る場合(xとyが異なる）
        int idx = 1;
        int nextX = x1 + diffX * idx;
        boolean flag = true;
        while  (true) {
            if (nextX < 0 || nextX > x) {
                // System.out.println(String.format("[A] x : %d, y : %d", nextX, y1));
                flag = false;
                break;
            }
            if (nextX == x2) {
                break;
            }
            if (!cards[nextX][y1].equals(".")) {
                // System.out.println(String.format("[B] x : %d, y : %d", nextX, y1));
                flag = false;
                break;
            }
            idx++;
            nextX = x1 + diffX * idx;
        }
        if (flag) {
            idx = 1;
            int nextY = y1 + diffY * idx;
            while  (true) {
                if (nextY < 0 || nextY > y) {
                    // System.out.println(String.format("[C] x : %d, y : %d", nextX, nextY));
                    return false;
                }
                if (nextY == y2) {
                    break;
                }
                if (!cards[nextX - diffX][nextY].equals(".")) {
                    // System.out.println(String.format("[D] x : %d, y : %d", nextX, nextY));
                    return false;
                }
                idx++;
                nextY = y1 + diffY * idx;
            }
            return cards[nextX][nextY].equals(cards[x1][y1]);
        }
        else {
            flag = true;
            idx = 1;
            int nextY = y1 + diffY * idx;
            while  (true) {
                if (nextY < 0 || nextY > y) {
                    // System.out.println(String.format("[C] x : %d, y : %d", nextX, nextY));
                    flag = false;
                    break;
                }
                if (nextY == y2) {
                    break;
                }
                if (!cards[x1][nextY].equals(".")) {
                    // System.out.println(String.format("[D] x : %d, y : %d", nextX, nextY));
                    flag = false;
                    break;
                }
                idx++;
                nextY = y1 + diffY * idx;
            }
            // System.out.println(String.format("[B] x : %d, y : %d, %s", x1, nextY , flag));
            if (flag) {
                idx = 1;
                nextX = x1 + diffX * idx;
                while  (true) {
                    // System.out.println(String.format("[E] x : %d, y : %d, x2 : %d", nextX, nextY, x2));
                    if (nextX < 0 || nextX > x) {
                        // System.out.println(String.format("[A] x : %d, y : %d", nextX, nextY));
                        return false;
                    }
                    if (nextX == x2) {
                        break;
                    }
                    if (!cards[nextX][nextY - diffY].equals(".")) {
                        // System.out.println(String.format("[B] x : %d, y : %d, x2 : %d", nextX, nextY, x2));
                        return false;
                    }
                    idx++;
                    nextX = x1 + diffX * idx;
                }
                return cards[nextX][nextY].equals(cards[x1][y1]);
            }
        }
        return false;
    }
}
