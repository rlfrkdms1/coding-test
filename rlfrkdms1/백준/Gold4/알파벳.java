import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int answer = 0;
    static int R, C;
    static char[][] board;
    static Set<Character> visited = new HashSet<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());

        board = new char[R][C];
        for(int i = 0; i < R; i++) {
            String alphabets = reader.readLine();
            for(int j = 0; j < C; j++) {
               board[i][j] = alphabets.charAt(j);
            }
        }

        visited.add(board[0][0]);
        dfs(0, 0);

        System.out.println(answer);
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int x, int y) {

        for(int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];

            if(tx >= 0 && tx < R && ty >= 0 && ty < C && !visited.contains(board[tx][ty])) {
                visited.add(board[tx][ty]);
                dfs(tx, ty);
                visited.remove(board[tx][ty]);
            }
        }

        answer = Math.max(visited.size(), answer);
    }
}
