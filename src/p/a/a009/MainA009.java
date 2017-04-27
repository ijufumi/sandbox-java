package p.a.a009;

import java.util.*;

public class MainA009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] data = line.split(" ");
        int h = Integer.parseInt(data[0]);
        int w = Integer.parseInt(data[1]);

        String[][] mass = new String[h][w];

        for (int i=0;i < h;i++) {
            line = sc.nextLine();
            mass[i] = new String[w];
            for (int j=0;j < w;j++) {
                mass[i][j] = String.valueOf(line.charAt(j));
            }

        }

        int count = calc(mass, h, w);

        System.out.println(count);
    }

    private static int calc(String[][] mass, int h, int w) {

        int count = 0;

        int x = 0;
        int y = 0;
        GoTo goTo = GoTo.RIGHT;

        out:
        while (true) {
//            System.out.println(String.format("[%d, %d] : %s", y, x, mass[y][x]));
            switch (goTo) {
                case TOP:
                    if (y == -1) {
                        break out;
                    }
                    if(mass[y][x].equals("/")) {
                        goTo = GoTo.RIGHT;
                        x++;
                    }
                    else if(mass[y][x].equals("\\")) {
                        goTo = GoTo.LEFT;
                        x--;
                    }
                    else {
                        y--;
                    }
                    break;
                case RIGHT:
                    if (x == w) {
                        break out;
                    }
                    if(mass[y][x].equals("/")) {
                        goTo = GoTo.TOP;
                        y--;
                    }
                    else if(mass[y][x].equals("\\")) {
                        goTo = GoTo.DOWN;
                        y++;
                    }
                    else {
                        x++;
                    }
                    break;
                case DOWN:
                    if (y == h) {
                        break out;
                    }
                    if(mass[y][x].equals("/")) {
                        goTo = GoTo.LEFT;
                        x--;
                    }
                    else if(mass[y][x].equals("\\")) {
                        goTo = GoTo.RIGHT;
                        x++;
                    }
                    else {
                        y++;
                    }
                    break;
                case LEFT:
                    if (x == -1) {
                        break out;
                    }
                    if(mass[y][x].equals("/")) {
                        goTo = GoTo.DOWN;
                        y++;
                    }
                    else if(mass[y][x].equals("\\")) {
                        goTo = GoTo.TOP;
                        y--;
                    }
                    else {
                        x--;
                    }
                    break;
            }
            count++;
        }

        return count;
    }

    enum GoTo {
        TOP,
        LEFT,
        RIGHT,
        DOWN;
    }
}
