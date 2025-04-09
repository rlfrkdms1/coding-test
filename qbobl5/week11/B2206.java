import java.util.*;
import java.io.*;

public class B2206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] visited = new int[N][M];

        for(int i=0; i<N; i++) {
            String input = br.readLine();
            Arrays.fill(visited[i], Integer.MAX_VALUE);
            for(int j=0; j<M; j++) map[i][j] = input.charAt(j) - '0';
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 1});
        visited[0][0] = 0;

        int distance = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            if(current[0] == N - 1 && current[1] == M - 1) {
                distance = current[3];
                break;
            }

            for(int i=0; i<4; i++) {
                int r = current[0] + dx[i];
                int c = current[1] + dy[i];

                if(r < 0 || r >= N || c < 0 || c >= M) continue;
                if(visited[r][c] <= current[2]) continue;

                if(map[r][c] == 1) {
                    if(current[2] == 0) {
                        visited[r][c] = current[2] + 1;
                        queue.offer(new int[]{r, c, current[2] + 1, current[3] + 1});
                    }
                } else {
                    visited[r][c] = current[2];
                    queue.offer(new int[]{r, c, current[2], current[3] + 1});
                }
            }
        }
        System.out.println(distance == Integer.MAX_VALUE ? -1 : distance);
    }
}
