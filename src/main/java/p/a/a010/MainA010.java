package p.a.a010;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import static java.util.Collections.reverseOrder;
import static java.util.Map.Entry.comparingByValue;

public class MainA010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<Integer, Integer> counter = new HashMap<>();
        double[][] point = new double[n][2];

        for (int i=0;i < n;i++) {
            String[] data = sc.nextLine().split(" ");
            int x = Integer.parseInt(data[0]);
            int y = Integer.parseInt(data[1]);
            long r = Long.parseLong(data[2]);

            if (r < Math.abs(y)) {
                continue;
            }
            double length = calc(y, r);

            point[i][0] = Math.max(x - length, 0);
            point[i][1] = Math.min(x + length, 10000);
        }

        int num = counter.entrySet().stream().sorted(reverseOrder(comparingByValue())).findFirst().map(Map.Entry::getValue).orElse(0);
        System.out.println(num);
    }

    private static double calc(int y, long r) {
        return new BigDecimal(Math.sqrt(Math.pow(r, 2) - Math.pow(y, 2))).setScale(0, RoundingMode.DOWN).doubleValue();
    }

    private static int count(double[][] point) {
        int count = 0;
        double start = 0;
        double end = 10000;
        for (int i = 0;i < point.length;i++) {
            for (int j=0;j < point.length;j++) {
                if (i == j) {
                    break;
                }


            }
        }
        return 0;
    }
}
