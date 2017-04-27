package p.a.a007;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by iju on 11/4/16.
 */
public class MainA007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] data = line.split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);

        Set<Integer>[] friends = new Set[n];
        for (int i=0;i < n;i++) {
            friends[i] = new HashSet<>();
        }

        for (int i=0;i < m;i++) {
            data = sc.nextLine().split(" ");
            int a = Integer.parseInt(data[1]) - 1;
            int b = Integer.parseInt(data[2]) - 1;
            if ("0".equals(data[0])) {
                friends[a].add(b);
                friends[b].add(a);
                // addFriends(friends, a, b);
            }
            else {
                if (contains(friends, a, b, new HashSet<>(Arrays.asList(b)))) {
                    friends[a].add(b);
                    // friends[b].add(a);
                    System.out.println("yes");
                }
                else {
                    System.out.println("no");
                }
            }
        }
    }
    private static boolean contains(Set<Integer>[] friends, int a, int b, Set<Integer> passed) {
        if (passed.contains(a)) {
            return false;
        }

        if (friends[a].contains(b)) {
            return true;
        }
        passed.add(a);
        boolean flag = false;
        for (int i : friends[a]) {
            if (i == b) {
                continue;
            }
             flag = contains(friends, i, b, passed);
             if (flag) {
                 break;
             }
        }

        return flag;
    }
}
