package hcu55.week07;

import java.io.*;
import java.util.*;

// 인구 이동(graph), 골드 IV
public class 인구이동 {
    static int N, L, R;
    static int[][] map;         
    static boolean[][] visited; 
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); 
        L = Integer.parseInt(st.nextToken()); 
        R = Integer.parseInt(st.nextToken()); 

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        
        while (true) {
            visited = new boolean[N][N]; 
            boolean move = false;  

            for (int i = 0; i < N; i++) { 
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        boolean result = bfs(i, j);
                        if (result) move = true;
                    }
                }
            }

            if (!move) break;
            day++;
        }

        System.out.println(day);
    }

    public static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> union = new ArrayList<>();

        queue.add(new int[]{x, y});
        union.add(new int[]{x, y});
        visited[x][y] = true;

        int sum = map[x][y]; 
        int count = 1;       

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int dir = 0; dir < 4; dir++) {
                int nextX = nowX + dx[dir];
                int nextY = nowY + dy[dir];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    if (!visited[nextX][nextY]) {
                        int diff = Math.abs(map[nowX][nowY] - map[nextX][nextY]);
                        if (diff >= L && diff <= R) { 
                            visited[nextX][nextY] = true;
                            queue.add(new int[]{nextX, nextY});
                            union.add(new int[]{nextX, nextY});
                            sum += map[nextX][nextY]; 
                            count++;           
                        }
                    }
                }
            }
        }

        if (count == 1) return false; 

        int avg = sum / count;
        for (int[] pos : union) {
            map[pos[0]][pos[1]] = avg; 
        }
        return true; 
    }
}
