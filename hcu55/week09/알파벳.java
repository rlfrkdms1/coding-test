package hcu55.week09;

import java.io.*;
import java.util.*;

// 알파벳(backtracking), 골드 IV
public class 알파벳 {
    static int r, c;
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;
    static boolean[] alpha;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new int[r][c];
        alpha = new boolean[26];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = str.charAt(j) - 'A';
            }
        }

        backtracking(0, 0, 1);
        System.out.println(max);
    }

    public static void backtracking(int x, int y, int len) {
        alpha[board[x][y]] = true;
        max = Math.max(max, len);

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextY >= 0 && nextX < r && nextY < c) {
                if (alpha[board[nextX][nextY]] == false) {
                    backtracking(nextX, nextY, len + 1);
                    alpha[board[nextX][nextY]] = false;
                }
            }
        }
    }
}
