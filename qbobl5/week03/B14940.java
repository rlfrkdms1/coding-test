import java.util.*;
import java.io.*;

public class B14940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int startRow = 0;
        int startCol = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        int[][] distance = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startRow, startCol});
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            for(int i=0; i<4; i++) {
                int row = dx[i] + node[0];
                int col = dy[i] + node[1];
                if(row >= 0 && col >= 0 && row < n && col < m) {
                    if(map[row][col] != 0 && distance[row][col] == 0 && map[row][col] != 2) {
                        distance[row][col] = distance[node[0]][node[1]] + 1;
                        queue.offer(new int[] {row, col});
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(distance[i][j] == 0 && map[i][j] != 2 && map[i][j] != 0) distance[i][j] = -1;
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) sb.append(distance[i][j]).append(" ");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
