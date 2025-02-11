import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        int[] start = new int[2];
        
        for(int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
                if(map[i][j] == 2) start = new int[] {i, j};
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        map[start[0]][start[1]] = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            int[] position = queue.poll();

            for(int i = 0; i < 4; i++) {
                int tx = position[0] + dx[i];
                int ty = position[1] + dy[i];

                if(tx >= 0 && tx < n && ty >= 0 && ty < m && !visited[tx][ty] && map[tx][ty] != 0) {
                    visited[tx][ty] = true;
                    map[tx][ty] += map[position[0]][position[1]];
                    queue.offer(new int[] {tx, ty});
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] != 0) answer.append("-1").append(" ");
                else answer.append(map[i][j]).append(" ");
            }
            answer.append(System.lineSeparator());
        }
        System.out.println(answer.toString());
    }
}
