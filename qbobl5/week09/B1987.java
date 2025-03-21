import java.util.*;
import java.io.*;

public class B1987 {
    static int R;
    static int C;
    static int[][] board;
    static boolean[] alphabet;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;

    static void dfs(int row, int col, int count) {
        max = Math.max(max, count);
        for(int i=0; i<4; i++) {
            int r = row + dx[i];
            int c = col + dy[i];
            if(r < 0 || c < 0 || r >= R || c >= C || alphabet[board[r][c]]) continue;
            alphabet[board[r][c]] = true;
            dfs(r, c, count + 1);
            alphabet[board[r][c]] = false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        alphabet = new boolean['Z' - 'A' + 1];
        for(int i=0; i<R; i++) {
            String input = br.readLine();
            for(int j=0; j<C; j++) board[i][j] = input.charAt(j) - 'A';
        }
        alphabet[board[0][0]] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }
}
