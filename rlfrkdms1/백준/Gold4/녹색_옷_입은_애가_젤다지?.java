import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int index = 1;
        StringBuilder answer = new StringBuilder();
        
        while(true) {
            int N = Integer.parseInt(reader.readLine());
            
            if(N == 0) break;

            int[][] map = new int[N][N];
            for(int i = 0; i < N; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for(int j = 0; j < N; j++) map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }

            answer.append("Problem ").append(index++).append(": ").append(getLostCost(map, N)).append("\n");
        }
        
        System.out.println(answer.toString());
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    private static int getLostCost(int[][] map, int N) {
        int[][] costs = new int[N][N];
        for(int[] cost : costs) Arrays.fill(cost, Integer.MAX_VALUE);
        costs[0][0] = map[0][0];

        Queue<int[]> path = new LinkedList<>();
        path.offer(new int[] {0, 0});

        while(!path.isEmpty()) {
            int[] temp = path.poll();

            for(int i = 0; i < 4; i++) {
                int tx = temp[0] + dx[i];
                int ty = temp[1] + dy[i];

                if(tx >= 0 && tx < N && ty >= 0 && ty < N && map[tx][ty] + costs[temp[0]][temp[1]] < costs[tx][ty]) {
                    costs[tx][ty] = map[tx][ty] + costs[temp[0]][temp[1]];
                    path.offer(new int[] {tx, ty});
                }
            }
        }

        return costs[N - 1][N - 1];
    }
}
