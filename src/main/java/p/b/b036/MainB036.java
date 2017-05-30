package p.b.b036;

import java.util.*;

/**
 * Created by iju on 11/21/16.
 */
public class MainB036 {
    static final String PARTY_R = "Republican";
    static final String PARTY_D = "Democratic";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int n = Integer.parseInt(line);
        int[] vote = new int[n];
        Map<Integer, String> partyMap = new HashMap<>();
        for (int i=1;i <= n;i++) {
            partyMap.put(i, sc.nextLine());
        }

        int v = Integer.parseInt(sc.nextLine());
        String[][] result = new String[v][];

        for (int i=0;i < v;i++) {
            line = sc.nextLine();
            String[] rec = line.split(" ");
            result[i] = rec;
            boolean partyRFlag = false;
            boolean partyDFlag = false;

            for (int j=0;j < rec.length;j++) {
                int idx = Integer.parseInt(rec[j]);
                String party = partyMap.get(idx);
                if (PARTY_R.equals(party) && !partyRFlag) {
                    vote[idx - 1]++;
                    partyRFlag = true;
                }
                else if (PARTY_D.equals(party) && !partyDFlag) {
                    vote[idx - 1]++;
                    partyDFlag = true;
                }
                if (partyRFlag && partyDFlag) {
                    break;
                }
            }
        }
        int preR = partyMap.entrySet().stream().filter(x -> x.getValue().equals(PARTY_R)).sorted((x, y) -> {
            int v1 = vote[x.getKey() - 1];
            int v2 = vote[y.getKey() - 1];
            if (v1 < v2) {
                return 1;
            }
            return -1;
        }).findFirst().map(x -> x.getKey()).get();

        int preD = partyMap.entrySet().stream().filter(x -> x.getValue().equals(PARTY_D)).sorted((x, y) -> {
            int v1 = vote[x.getKey() - 1];
            int v2 = vote[y.getKey() - 1];
            if (v1 < v2) {
                return 1;
            }
            return -1;
        }).findFirst().map(x -> x.getKey()).get();

        int countR = 0;
        int countD = 0;
        for (int i=0;i < v;i++) {
            String[] rec = result[i];
            for (int j=0;j < rec.length;j++) {
                int idx = Integer.parseInt(rec[j]);
                if (idx == preD) {
                    countD++;
                    break;
                }
                else if (idx == preR) {
                    countR++;
                    break;
                }
            }

        }
        if (countR > countD) {
            System.out.println(preR);
        }else {
            System.out.println(preD);
        }
    }
}
