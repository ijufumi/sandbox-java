package p.b.b028;

import java.util.*;

public class MainB028 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] data = line.split(" ");
        int n = Integer.parseInt(data[0]);
        int g = Integer.parseInt(data[1]);
        int m = Integer.parseInt(data[2]);

        Map<Integer, List<String>> groupMap = new HashMap<>();
        List<String>[] messageList = new List[n];

        for (int i=0;i < g;i++) {
            line = sc.nextLine();
            String[] rec = line.split(" ");

            groupMap.put(i, Arrays.asList(Arrays.copyOfRange(rec, 1, rec.length)));
        }

        for (int i=0;i < m;i++) {
            line = sc.nextLine();
            String[] rec = line.split(" ");
            int f = Integer.parseInt(rec[0]) - 1;
            int t = Integer.parseInt(rec[2]) - 1;
            if ("0".equals(rec[1])) {
                addMessage(f, messageList, rec[3]);
                addMessage(t, messageList, rec[3]);
            }
            else
            {
                // addMessage(f, messageList, rec[3]);
                boolean flag = false;
                for (String gm : groupMap.get(t)) {
                    int gmi = Integer.parseInt(gm) - 1;
                    if (gmi == f) {
                        flag = true;
                        break;
                    }
                }
                if (flag){
                    for (String gm : groupMap.get(t)) {
                        int gmi = Integer.parseInt(gm) - 1;
                        addMessage(gmi, messageList, rec[3]);
                    }
                }
            }
        }

        for (int i = 0;i < n;i++) {
            List<String> list = messageList[i];

            if (list != null) {
                for (String mm : list) {
                    System.out.println(mm);
                }
            }

            if (i != (n - 1))
            {
                System.out.println("--");
            }
        }
    }

    private static void addMessage(int i, List<String>[] messageList, String message) {
        if (messageList[i] == null) {
            messageList[i] = new ArrayList<>();
        }
        messageList[i].add(message);
    }
}
