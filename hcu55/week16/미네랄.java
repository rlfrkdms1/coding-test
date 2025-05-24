package hcu55.week16;

import java.io.*;
import java.util.*;

// 미네랄(graph+bfs+impl), 골드 I
public class 미네랄 {
    static int R, C;
    static int[][] cave;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        cave = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = str.charAt(j);
                if (c == '.') cave[i][j] = 0;
                else cave[i][j] = 1;
            }
        }

        int N = Integer.parseInt(br.readLine());
        int[] height = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            throwPole(i, height[i]);
            bfsCluster();
            List<int[]> floating = floatingCluster();
            if (!floating.isEmpty()) {
                drop(floating);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (cave[i][j] == 0) sb.append(".");
                else sb.append("x");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void throwPole(int turn, int height) {
        int high = R - height;

        if (turn % 2 == 0) {
            for (int left = 0; left < C; left++) {
                if (cave[high][left] == 1) {
                    cave[high][left] = 0;
                    return;
                }
            }
        } else {
            for (int right = C - 1; right >= 0; right--) {
                if (cave[high][right] == 1) {
                    cave[high][right] = 0;
                    return;
                }
            }
        }
    }

    public static void bfsCluster() {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[R][C];

        for (int col = 0; col < C; col++) {
            if (cave[R - 1][col] == 1 && !visited[R - 1][col]) {
                queue.add(new int[]{R - 1, col});
                visited[R - 1][col] = true;
            }
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C) {
                    if (cave[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }

    public static List<int[]> floatingCluster() {
        List<int[]> floating = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (cave[i][j] == 1 && !visited[i][j]) {
                    floating.add(new int[]{i, j});
                }
            }
        }

        return floating;
    }

    public static void drop(List<int[]> cluster) {
        for (int[] c : cluster) {
            cave[c[0]][c[1]] = 0;
        }

        int dropDist = 0;
        boolean canDrop = true;

        while (canDrop) {
            for (int[] c : cluster) {
                int nx = c[0] + dropDist + 1;
                int ny = c[1];

                if (nx >= R || (cave[nx][ny] == 1 && visited[nx][ny])) {
                    canDrop = false;
                    break;
                }
            }
            if (canDrop) dropDist++;
        }

        for (int[] c : cluster) {
            cave[c[0] + dropDist][c[1]] = 1; 
        }
    }
}
