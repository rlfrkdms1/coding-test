package hcu55.week06;

import java.io.*;
import java.util.*;

// 틱택토(impl), 골드 V
public class 틱택토 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String line = br.readLine();

            if (line.equals("end")) {
                break;
            }

            if (isValid(line)) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
        }
    }

    public static boolean isValid(String str) {
        char[] board = str.toCharArray();

        int xCount = 0;
        int oCount = 0;

        for (char c : board) {
            if (c == 'X') xCount++;
            if (c == 'O') oCount++;
        }

        boolean xWin = isWin(board, 'X');
        boolean oWin = isWin(board, 'O');

        if (!(xCount == oCount || xCount == oCount + 1)) {
            return false;
        }

        if (xWin && oWin) {
            return false;
        }

        if (xWin && xCount != oCount + 1) {
            return false;
        }

        if (oWin && xCount != oCount) {
            return false;
        }

        if (!xWin && !oWin && xCount + oCount != 9) {
            return false;
        }

        return true;
    }

    public static boolean isWin(char[] board, char shape) {
        
        for (int i = 0; i < 3; i++) {
            if (board[i * 3] == shape && board[i * 3 + 1] == shape && board[i * 3 + 2] == shape) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[i] == shape && board[i + 3] == shape && board[i + 6] == shape) {
                return true;
            }
        }

        if (board[0] == shape && board[4] == shape && board[8] == shape) {
            return true;
        }

        if (board[2] == shape && board[4] == shape && board[6] == shape) {
            return true;
        }

        return false;
    }
}
