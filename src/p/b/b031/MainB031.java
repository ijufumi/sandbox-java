package p.b.b031;

import java.util.*;
/**
 * Created by iju on 10/5/16.
 */
public class MainB031 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int n = Integer.parseInt(line);
        String[] board = new String[n];
        line = sc.nextLine();
        for (int i=0;i < n;i++) {
            board[i] = String.valueOf(line.charAt(i));
        }
        String[] nextBoard = new String[n];
        System.arraycopy(board, 0, nextBoard, 0, n);
        while(true) {
            boolean isExit = true;
            for (int i=0;i < n;i++) {
                String b1 = board[i];
                for (int j=i + 1; j < n;j++) {
                    String b2 = board[j];
                    if (!b1.equals(b2)) {
                        continue;
                    }
                    if (j - i == 1){
                        break;
                    }
                    isExit = false;

                    for (int k=i+1;k < j;k++) {
                        nextBoard[k] = b1;
                    }
                    //i = j - 1;
                    break;
                }
            }
            System.arraycopy(nextBoard, 0, board, 0, n);
            if (isExit) {
                break;
            }
        }
        int count = 0;
        for (int i=0;i < n;i++) {
            if (board[i].equals("b")) {
                count++;
            }
        }

        System.out.println(count);
    }
}
