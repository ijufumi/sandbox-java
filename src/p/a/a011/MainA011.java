package p.a.a011;


import java.util.*;

public class MainA011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] data = line.split(" ");
        int d = Integer.parseInt(data[0]);
        int n = Integer.parseInt(data[1]);

        int[] a = new int[n];
        for (int i=0;i < n;i++) {
            a[i] = Integer.parseInt(sc.nextLine());
        }

        int position = 0;
        String[] history = new String[n];
        int idx = 0;
        while(idx < n) {
            if ((history[idx] == null || "R".equals(history[idx])) && (position - a[idx]) >= -d) {
                position -= a[idx];
                history[idx] = "L";
                idx++;
            }
            else if ((history[idx] == null || "L".equals(history[idx]))  && (position + a[idx]) <= d) {
                position += a[idx];
                history[idx] = "R";
                idx++;
            } else {
                if ("R".equals(history[idx - 1])) {
                    position -= a[idx - 1];
                } else if ("L".equals(history[idx - 1])) {
                    position += a[idx - 1];
                }
                history[idx] = null;
                idx--;
            }
        }

        for(String s : history) {

            System.out.print(s);
        }
        System.out.println();
    }
}
