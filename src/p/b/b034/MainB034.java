package p.b.b034;

import java.util.*;
import java.util.stream.Stream;

public class MainB034 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // start position
        String[] rec = sc.nextLine().split(" ");
        int[] p = new int[2];
        p[0] = Integer.parseInt(rec[0]); // x
        p[1] = Integer.parseInt(rec[1]); // y

        // move amount
        rec = sc.nextLine().split(" ");
        int f = Integer.parseInt(rec[0]);
        int r = Integer.parseInt(rec[1]);
        int b = Integer.parseInt(rec[2]);
        int l = Integer.parseInt(rec[3]);

        // count
        int n = Integer.parseInt(sc.nextLine());

        Direction d = Direction.UP;

        for (int i=0;i < n;i++) {
            String[] data = sc.nextLine().split(" ");
            if ("t".equals(data[0])) {
                switch (data[1]) {
                    case "R":
                        d = d.toR();
                        break;
                    case "L":
                        d = d.toL();
                        break;
                    case "B":
                        d = d.toB();
                        break;
                    default:
                        d = d.toF();
                }
            }
            else {
                Direction moveD = Direction.of(data[1]);
                move(p, f, r, b, l, d, moveD);
            }
        }

        System.out.println(String.format("%d %d", p[0], p[1]));
    }

    private static void move(int[] p, int f, int r, int b, int l, Direction d, Direction moveD) {
        switch (d) {
            case UP:
                switch (moveD) {
                    case UP:
                        p[1] += f;
                        break;
                    case DOWN:
                        p[1] -= b;
                        break;
                    case LEFT:
                        p[0] -= l;
                        break;
                    case RIGHT:
                        p[0] += r;
                        break;
                }
                break;
            case DOWN:
                switch (moveD) {
                    case UP:
                        p[1] -= f;
                        break;
                    case DOWN:
                        p[1] += b;
                        break;
                    case LEFT:
                        p[0] += l;
                        break;
                    case RIGHT:
                        p[0] -= r;
                        break;
                }
                break;
            case LEFT:
                switch (moveD) {
                    case UP:
                        p[0] -= f;
                        break;
                    case DOWN:
                        p[0] += b;
                        break;
                    case LEFT:
                        p[1] -= l;
                        break;
                    case RIGHT:
                        p[1] += r;
                        break;
                }
                break;
            case RIGHT:
                switch (moveD) {
                    case UP:
                        p[0] += f;
                        break;
                    case DOWN:
                        p[0] -= b;
                        break;
                    case LEFT:
                        p[1] += l;
                        break;
                    case RIGHT:
                        p[1] -= r;
                        break;
                }
                break;
        }
    }

    enum Direction {
        UP("F"){
            public Direction toF(){
                return UP;
            }
            public Direction toR(){
                return RIGHT;
            }
            public Direction toB() {
                return DOWN;
            }
            public Direction toL() {
                return LEFT;
            }
        },
        DOWN("B"){
            public Direction toF(){
                return DOWN;
            }
            public Direction toR(){
                return LEFT;
            }
            public Direction toB() {
                return UP;
            }
            public Direction toL() {
                return RIGHT;
            }
        },
        LEFT("L"){
            public Direction toF(){
                return LEFT;
            }
            public Direction toR(){
                return UP;
            }
            public Direction toB() {
                return RIGHT;
            }
            public Direction toL() {
                return DOWN;
            }
        },
        RIGHT("R"){
            public Direction toF(){
                return RIGHT;
            }
            public Direction toR(){
                return DOWN;
            }
            public Direction toB() {
                return LEFT;
            }
            public Direction toL() {
                return UP;
            }
        }
        ;

        abstract Direction toF();
        abstract Direction toR();
        abstract Direction toB();
        abstract Direction toL();

        String s;
        Direction(String s) {
            this.s = s;
        }
        public static Direction of(String str) {
            return Stream.of(values()).filter(x -> x.s.equals(str)).findFirst().get();
        }
    }
}
