package hcu55.week08;

import java.util.*;
import java.io.*;

// 녹색 옷 입은 애가 젤다지?(dijkstra), 골드 IV
public class 녹색옷입은애가젤다지 {
    static int[][] area;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int INF = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int num = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            sb.append("Problem ").append(num++).append(": ");
            area = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    area[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append(dijkstra(area, N)).append('\n');
        }
        System.out.println(sb);
    }

    public static int dijkstra(int[][] area, int n) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]); 

        int[][] dijk = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dijk[i], INF);

        queue.offer(new int[]{0, 0, area[0][0]});
        dijk[0][0] = area[0][0];

        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n
                        && dijk[nextX][nextY] > dijk[nowX][nowY] + area[nextX][nextY]) {
                    dijk[nextX][nextY] = dijk[nowX][nowY] + area[nextX][nextY];
                    queue.offer(new int[]{nextX, nextY, dijk[nextX][nextY]});
                }
            }
        }
        return dijk[n - 1][n - 1];
    }
}
