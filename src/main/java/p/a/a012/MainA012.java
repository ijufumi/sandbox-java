package p.a.a012;

import java.util.*;
import java.util.stream.Collectors;

public class MainA012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] data = line.split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);

        int[][] practice = new int[n][4];
        for (int i =0;i < n;i++) {
            line = sc.nextLine();
            data = line.split(" ");
            for (int j=0;j < 4;j++) {
                practice[i][j] = Integer.parseInt(data[j]);
            }
        }

        int[][] skill = new int[m][4];
        for (int i =0;i < m;i++) {
            line = sc.nextLine();
            data = line.split(" ");
            for (int j=0;j < 4;j++) {
                skill[i][j] = Integer.parseInt(data[j]);
            }
        }
        for (int i=0;i < m;i++) {
            System.out.println(check(practice, skill[i]));
        }
    }

    private static int check(int[][] practice, int[] skill) {
        int[] order = judgeOrder(skill);

        // System.out.println(String.format("order : %d %d %d %d", order[0], order[1], order[2], order[3]));
        // System.out.println(String.format("before: %d %d %d %d", practice[0][0], practice[0][1], practice[0][2], practice[0][3]));

        // List<int[]> newPractice = Arrays.stream(practice).sorted(new PracticeComparator(order)).collect(Collectors.toList());
        // Arrays.sort(practice, new PracticeComparator(order));

        // System.out.println(String.format("after : %d %d %d %d", newPractice.get(0)[0], newPractice.get(0)[1], newPractice.get(0)[2], newPractice.get(0)[3]));

        int orderIdx = 0;
        int[] sum = new int[4];
        int count = 0;

        // System.out.println("check");
        List<int[]> checkedList = new ArrayList<>();
        while(orderIdx < 4) {
            int idx = order[orderIdx];
            List<int[]> newPractice = Arrays.stream(practice).filter(x -> {
                return checkedList.stream().filter(xx -> x[0] == xx[0] && x[1] == xx[1] && x[2] == xx[2] && x[3] == xx[3]).count() == 0;
            }).sorted(new PracticeComparator(idx)).collect(Collectors.toList());

            if (newPractice.isEmpty()) {
                checkedList.clear();
            }
            for (int i=0;i < newPractice.size();i++) {
                if (sum[idx] >= skill[idx]) {
                    orderIdx++;
                    break;
                }
                count++;
                sum[0] += newPractice.get(i)[0];
                sum[1] += newPractice.get(i)[1];
                sum[2] += newPractice.get(i)[2];
                sum[3] += newPractice.get(i)[3];

                checkedList.add(newPractice.get(i));
            }
            if (sum[0] >= skill[0] && sum[1] >= skill[1] && sum[2] >= skill[2] && sum[3] >= skill[3]) {
                break;
            }
        }

        return count;
    }

    private static int[] judgeOrder(int[] skill) {
        //System.out.println("judgeOrder start.");
        List<Integer> orderList = new ArrayList<>();

        while(orderList.size() < skill.length - 1) {
            int idx = -1;
            for (int i=0;i < skill.length;i++) {
                if (!orderList.contains(i)) {
                    if (idx == -1 || skill[idx] < skill[i]) {
                        idx = i;
                    }
                }
            }
            if (!orderList.contains(idx)) {
                orderList.add(idx);
            }
        }

        for (int i=0;i < skill.length;i++) {
            if (!orderList.contains(i)) {
                orderList.add(i);
                break;
            }
        }

        // System.out.println(orderList);
        int[] order = new int[skill.length];
        for (int i=0;i < skill.length;i++) {
            order[i] = orderList.get(i);
        }

        //System.out.println("judgeOrder end.");

        return order;
    }

    static class PracticeComparator implements Comparator<int[]> {
        private int idx1;
        private int idx2;
        private int idx3;
        private int idx4;

        private int idx;

        PracticeComparator(int idx) {
            this.idx = idx;
        }

        PracticeComparator(int[] order) {
            idx1 = order[0];
            idx2 = order[1];
            idx3 = order[2];
            idx4 = order[3];
        }

        @Override
        public int compare(int[] o1, int[] o2) {
            // System.out.println(String.format("order : %d %d %d %d", idx1, idx2, idx3, idx4));
            // System.out.println(String.format("o1: %d %d %d %d", o1[0], o1[1], o1[2], o1[3]));
            // System.out.println(String.format("o2: %d %d %d %d", o2[0], o2[1], o2[2], o2[3]));
            if (o1[idx] < o2[idx]) {
                return 1;
            }
            else if (o1[idx] > o2[idx]) {
                return -1;
            }

            return 0;
        }
    }
}
