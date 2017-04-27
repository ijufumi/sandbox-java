package p.b.b026;

import java.util.*;

public class MainB026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stock s = Stock.create(sc.nextLine());
        int num = Integer.parseInt(sc.nextLine());

        for (int i=0;i < num;i++) {
            InData d = InData.create(sc.nextLine());
            // System.out.println(d);
            check(s, d);
        }
    }

    static class Stock {
        int n500;
        int n100;
        int n50;
        int n10;

        static Stock create(String str) {
            String[] data = str.split(" ");

            Stock s = new Stock();
            s.n500 = Integer.parseInt(data[0]);
            s.n100 = Integer.parseInt(data[1]);
            s.n50 = Integer.parseInt(data[2]);
            s.n10 = Integer.parseInt(data[3]);

            return s;
        }
    }

    static class InData {
        int price;
        int n500;
        int n100;
        int n50;
        int n10;
        int diff;

        static InData create(String str) {
            String[] rec = str.split(" ");

            InData d = new InData();
            d.price = Integer.parseInt(rec[0]);
            d.n500 = Integer.parseInt(rec[1]);
            d.n100 = Integer.parseInt(rec[2]);
            d.n50 = Integer.parseInt(rec[3]);
            d.n10 = Integer.parseInt(rec[4]);
            d.diff = (d.n500 * 500 + d.n100 * 100 + d.n50 * 50 + d.n10 * 10) - d.price;

            return d;
        }

        public String toString() {
            return String.format("500:%d 100:%d 50:%d 10:%d (diff:%d)", n500, n100, n50, n10, diff);

        }
    }

    static void check(Stock s, InData d) {
        int n500 = d.diff/500;
        int n100 = (d.diff - n500 * 500)/100;
        int n50 = (d.diff - n500 * 500 - n100 * 100)/50;
        int n10 = (d.diff - n500 * 500 - n100 * 100 - n50 * 50)/10;

        // System.out.println(String.format("debug: %d %d %d %d", s.n500, s.n100, s.n50, s.n10));
        // System.out.println(String.format("debug: %d %d %d %d", n500, n100, n50, n10));

        boolean impossible = true;

        if (n500 <= s.n500 && n100 <= s.n100 && ((n50 <= s.n50 && n10 <= s.n10) || (n50 == 1 && s.n50 == 0 && s.n10 >= 5))) {
            if (s.n50 == 0) {
                n50 = 0;
                n10 = (d.diff - n500 * 500 - n100 * 100)/10;
            }
            System.out.println(String.format("%d %d %d %d", n500, n100, n50, n10));
            s.n500 -= n500;
            s.n100 -= n100;
            s.n50 -= n50;
            s.n10 -= n10;
            s.n500 += d.n500;
            s.n100 += d.n100;
            s.n50 += d.n50;
            s.n10 += d.n10;

            impossible = false;
        }
        else {
            n500 = 0;
            n100 = d.diff/100;
            n50 = (d.diff - n100 * 100)/50;
            n10 = (d.diff - n100 * 100 - n50 * 50)/10;

            // System.out.println(String.format("%d %d %d %d", n500, n100, n50, n10));

            if (n100 <= s.n100 && ((n50 <= s.n50 && n10 <= s.n10) || (n50 == 1 && s.n50 == 0 && s.n10 >= 5))) {
                if (s.n50 == 0) {
                    n50 = 0;
                    n10 = (d.diff - n100 * 100)/10;
                }
                System.out.println(String.format("%d %d %d %d", n500, n100, n50, n10));
                s.n100 -= n100;
                s.n50 -= n50;
                s.n10 -= n10;
                s.n500 += d.n500;
                s.n100 += d.n100;
                s.n50 += d.n50;
                s.n10 += d.n10;

                impossible = false;
            }
            else
            {
                if (n500 == 0 && n100 == 0) {
                    if (n50 == 1 && s.n50 == 0 && s.n10 >= 5) {
                        n50 = 0;
                        n10 = d.diff/10;
                        System.out.println(String.format("%d %d %d %d", n500, n100, n50, n10));
                        s.n10 -= n10;
                        s.n500 += d.n500;
                        s.n100 += d.n100;
                        s.n50 += d.n50;
                        s.n10 += d.n10;

                        impossible = false;
                    }
                }
            }
        }

        if (impossible) {
            System.out.println("impossible");
        }
    }
}
