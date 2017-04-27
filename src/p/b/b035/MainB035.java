package p.b.b035;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by iju on 10/25/16.
 */
public class MainB035 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        int t = Integer.parseInt(data[2]);

        Map<String, Integer> preMonth = new HashMap<>();
        for (int i=0;i < n;i++) {
            data = sc.nextLine().split(" ");
            preMonth.put(data[0], Integer.parseInt(data[1]));
        }

        Map<String, Integer> thisMonth = new HashMap<>();
        for (int i=0;i < m;i++) {
            data = sc.nextLine().split(" ");
            int total = Integer.parseInt(data[2]);
            if (thisMonth.containsKey(data[1])) {
                total += thisMonth.get(data[1]);
            }
            thisMonth.put(data[1], total);
        }

        for(Map.Entry<String, Integer> e : preMonth.entrySet()) {
            String name = e.getKey();
            if (!thisMonth.containsKey(name)) {
                thisMonth.put(name, 0);
            }
        }
        List<String> preMonthTop = preMonth.entrySet().stream().sorted((v1, v2) -> {
            if (v1.getValue() > v2.getValue()) {
                return -1;
            }
            if (v1.getValue() < v2.getValue()) {
                return 1;
            }
            return v1.getKey().compareTo(v2.getKey());
        }).map(Map.Entry::getKey).collect(Collectors.toList());

        Map<String, Integer> preMonthTopMap = new HashMap<>();
        for (int i=0;i < preMonthTop.size();i++) {
            preMonthTopMap.put(preMonthTop.get(i), i+ 1);
        }
        List<String> thisMonthTop = thisMonth.entrySet().stream().sorted((v1, v2) -> {
            if (v1.getValue() > v2.getValue()) {
                return -1;
            }
            if (v1.getValue() < v2.getValue()) {
                return 1;
            }
            return v1.getKey().compareTo(v2.getKey());
        }).map(Map.Entry::getKey).collect(Collectors.toList());
        int size = (t > thisMonthTop.size()) ? thisMonthTop.size() : t;
        for (int i=0;i < size;i++) {
            String name = thisMonthTop.get(i);
            int distance = thisMonth.get(name);
            String same = "";
            if (!preMonth.containsKey(name)) {
                same = "new";
            }
            else {
                int preRank = preMonthTopMap.get(name);
                int thisRank = i + 1;

                if (preRank > t) {
                    same = "new";
                }
                else if (preRank == thisRank) {
                    same = "same";
                } else if (preRank > thisRank) {
                    same = "up";
                } else {
                    // System.out.println(String.format("%d %d", preRank, thisRank));
                    same = "down";
                }
            }
            System.out.println(String.format("%s %d %s", name, distance, same));
        }
    }
}
