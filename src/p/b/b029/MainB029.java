package p.b.b029;

import java.math.BigDecimal;
import java.util.*;

public class MainB029 {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] data = line.split(" ");
        int x = Integer.parseInt(data[0]);
        int y = Integer.parseInt(data[1]);

        int k = Integer.parseInt(sc.nextLine());

        int n = Integer.parseInt(sc.nextLine());

        int[][] z = new int[n][3];

        Map<Integer, Double> distanceMap = new HashMap<>();
        for (int i=0;i < n;i++) {
            line = sc.nextLine();
            String[] rec = line.split(" ");
            z[i][0] = Integer.parseInt(rec[0]);
            z[i][1] = Integer.parseInt(rec[1]);
            z[i][2] = Integer.parseInt(rec[2]);

            distanceMap.put(i, Math.hypot(x - z[i][0], y - z[i][1]));
            //System.out.println(distanceMap.get(i));
        }


        class Sum {
            int sum = 0;
            int count = 0;
        }
        Sum sum = new Sum();
        distanceMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(u -> {
            sum.count++;
            if (sum.count <= k) {
                sum.sum += z[u.getKey()][2];
            }
        });
        System.out.println(new BigDecimal(sum.sum).divide(new BigDecimal(k), BigDecimal.ROUND_HALF_UP).intValue());
    }
}
