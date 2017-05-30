package p.b.b024;

import java.util.*;

public class MainB024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        double r = Double.parseDouble(line);
        int num = (int) Math.ceil(r);
        int count = 1;
        for (int i=1;i <= num;i++) {
            for (int j=1;j <= num;j++) {
                double distance = Math.sqrt(i * i + j * j);

                if (distance <= r) {
                    count++;
                }
                else {
                    double preDistance = Math.sqrt(i * i + (j - 1) * (j - 1));
                    if (preDistance <= r) {
                        count++;
                    }
                    preDistance = Math.sqrt((i - 1) * (i - 1) + j * j);
                    if (preDistance <= r) {
                        count++;
                    }
                }
            }
        }
        // System.out.println(count);
        System.out.println(count * 4);
    }
}
