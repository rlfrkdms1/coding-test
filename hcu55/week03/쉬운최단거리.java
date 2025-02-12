package hcu55.week03;

import java.io.*;
import java.util.*;

// 쉬운 최단거리(bfs), 실버 I
public class 쉬운최단거리 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        int x = 0, y = 0;
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    x = i;
                    y = j;
                }
                map[i][j] = num;
            }
        }

        bfs(x, y);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    map[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = 0;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];
            
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        map[nextX][nextY] = map[nowX][nowY] + 1;
                    }
                }
            }
        }
    }
}
