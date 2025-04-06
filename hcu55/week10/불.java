package hcu55.week10;

import java.io.*;
import java.util.*;

// 불(dp), 골드 III
public class 불 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int R, C;
    static char[][] maze;
    static int[][] fireTime;
    static int[][] jihunTime;
    static Queue<int[]> fireQueue = new LinkedList<>();
    static Queue<int[]> jihunQueue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        maze = new char[R][C];
        fireTime = new int[R][C];
        jihunTime = new int[R][C];
        
        for (int i = 0; i < R; i++) {
            Arrays.fill(fireTime[i], -1);
            Arrays.fill(jihunTime[i], -1);
        }
        
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                maze[i][j] = str.charAt(j);
                if (maze[i][j] == 'F') {
                    fireQueue.add(new int[]{i, j});
                    fireTime[i][j] = 0;
                }
                if (maze[i][j] =='J') {
                    jihunQueue.add(new int[]{i, j});
                    jihunTime[i][j] = 0;
                }
            }
        }

        while (!fireQueue.isEmpty()) {
            int[] now = fireQueue.poll();
            int nowX = now[0];
            int nowY = now[1];
            
            for (int d = 0; d < 4; d++) {
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];
                
                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (maze[nx][ny] != '#' && fireTime[nx][ny] == -1) {
                        fireTime[nx][ny] = fireTime[nowX][nowY] + 1;
                        fireQueue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        while (!jihunQueue.isEmpty()) {
            int[] now = jihunQueue.poll();
            int nowX = now[0];
            int nowY = now[1];

            if (nowX == 0 || nowX == R - 1 || nowY == 0 || nowY == C - 1) {
                System.out.println(jihunTime[nowX][nowY] + 1);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];
                
                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (maze[nx][ny] != '#' && jihunTime[nx][ny] == -1) {
                        if (fireTime[nx][ny] == -1 || jihunTime[nowX][nowY] + 1 < fireTime[nx][ny]) {
                            jihunTime[nx][ny] = jihunTime[nowX][nowY] + 1;
                            jihunQueue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        
        System.out.println("IMPOSSIBLE");
    }
}
