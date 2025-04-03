import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int R = Integer.parseInt(tokenizer.nextToken());
        int C = Integer.parseInt(tokenizer.nextToken());

        int[] J = new int[2];
        String[][] map = new String[R][C];
        Queue<int[]> fires = new LinkedList<>();
        for(int i = 0; i < R; i++) {
            map[i] = reader.readLine().split("");
            for(int j = 0; j < C; j++) {
                if(map[i][j].equals("J")) J = new int[] {i, j};
                else if(map[i][j].equals("F")) fires.offer(new int[] {i, j});
            }
        }

        System.out.println(bfs(R, C, map, fires, J));

    }

    private static String bfs(int R, int C, String[][] map, Queue<int[]> fires, int[] J) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {J[0], J[1], 0});
        int time = -1;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[R][C];
        visited[J[0]][J[1]] = true;
        while(!queue.isEmpty()) {
            int[] jihoon = queue.poll();
            
            if(jihoon[2] != time) {
                time++;
                int size = fires.size();
                for(int i = 0; i < size; i++) {
                    int[] fire = fires.poll();
                    for(int j = 0; j < 4; j++) {
                        int tx = fire[0] + dx[j];
                        int ty = fire[1] + dy[j];

                        if(tx >= 0 && tx < R && ty >= 0 && ty < C && !map[tx][ty].equals("#") && !map[tx][ty].equals("F")) {
                            map[tx][ty] = "F";
                            fires.offer(new int[] {tx, ty});
                        } 
                    }
                }
            }

            if(jihoon[0] == 0 || jihoon[0] == R - 1 || jihoon[1] == 0 || jihoon[1] == C - 1) {
                return String.valueOf(jihoon[2] + 1);
            }
            
            for(int i = 0; i < 4; i++) {
                int tx = jihoon[0] + dx[i];
                int ty = jihoon[1] + dy[i];
                if(tx >= 0 && tx < R && ty >= 0 && ty < C && !map[tx][ty].equals("#") && !map[tx][ty].equals("F") && !visited[tx][ty]) {
                    visited[tx][ty] = true;
                    queue.offer(new int[] {tx, ty, time + 1});
                }
            }

        }
        
        return "IMPOSSIBLE";

    }
}
