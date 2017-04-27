package p.a.a008;

import java.util.*;

public class MainA008 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] data = line.split(" ");

        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);

        Integer[] plan = new Integer[m];
        for (int i=0;i < m;i++) {
            plan[i] = Integer.parseInt(sc.nextLine());
        }

        System.out.println(String.valueOf("Time:" + (System.currentTimeMillis() - startTime)/1000));

        int h = m/2;
        for (int i=0;i < m/2 - n;i++) {
            int temp = calc(n, i, h, plan);
            if (temp != 0 && temp < h) {
                h = temp;
                if (h == n) {
                    break;
                }
            }
        }
        System.out.println(String.valueOf(h));
        System.out.println(String.valueOf("Time:" + (System.currentTimeMillis() - startTime)/1000));
    }

    private static <T extends Object> int calc(int n, int start, int max, T[] plan) {
        Set<T> stock = new HashSet<>();
        int count=0;
        boolean matches = false;
        for (int i=start;i < max;i++) {
            count++;

            if(!stock.contains(plan[i])) stock.add(plan[i]);

            if (stock.size() == n) {
                matches = true;
                break;
            }
        }

        return (matches) ? count : 0;
    }
}
