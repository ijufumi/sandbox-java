package p.b.b025;

import java.util.*;

public class MainB025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] data = line.split(" ");
        int m = Integer.parseInt(data[0]);
        int n = Integer.parseInt(data[1]);
        int k = Integer.parseInt(data[2]);

        Map<Integer, Integer> placeMap = new HashMap<>();
        for(int i=1;i <= n;i++) {
            int idx = Integer.parseInt(sc.nextLine());
            placeMap.put(i, idx);
        }
        for(int i=0;i < k;i++) {
            for(int j=1;j <= n;j++) {
                if (placeMap.containsKey(j)) {
                    int idx = next(j, m, placeMap);
                    placeMap.put(j, idx);
                }
            }
        }

        for (int i=1;i <= n;i++) {
            if (placeMap.containsKey(i)) {
                System.out.println(placeMap.get(i));
            }
        }
    }

    private static int next(int j, int max, Map<Integer, Integer> placeMap) {
        int idx = placeMap.get(j);
        while(true) {
            boolean flag = false;
            if (idx == max) {
                idx = 1;
            }
            else {
                idx++;
            }
            for (Map.Entry<Integer, Integer> e : placeMap.entrySet()) {
                if (e.getKey() == j) {
                    continue;
                }
                if (e.getValue() == idx) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        return idx;
    }
}
