import java.io.*;
import java.util.*;

public class B4179 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        char[][] maze = new char[R][C];
        int[][] fire = new int[R][C];
        int[][] jihun = new int[R][C];

        Queue<int[]> blaze = new LinkedList<>();
        Queue<int[]> escape = new LinkedList<>();
        
        for(int i=0; i<R; i++) {
            String input = br.readLine();
            for(int j=0; j<C; j++) {
                maze[i][j] = input.charAt(j);
                fire[i][j] = -1;
                jihun[i][j] = -1;
                
                if(maze[i][j] == 'J') {
                    escape.offer(new int[]{i, j});
                    jihun[i][j] = 0;
                } else if(maze[i][j] == 'F') {
                    blaze.offer(new int[]{i, j});
                    fire[i][j] = 0;
                }
            }
        }
        
        while(!blaze.isEmpty()) {
            int[] current = blaze.poll();
            int x = current[0];
            int y = current[1];
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(maze[nx][ny] == '#' || fire[nx][ny] != -1) continue;
                fire[nx][ny] = fire[x][y] + 1;
                blaze.offer(new int[]{nx, ny});
            }
        }
        
        int result = -1;
        while(!escape.isEmpty()) {
            int[] current = escape.poll();
            int x = current[0];
            int y = current[1];

            if(x == 0 || y == 0 || x == R - 1 || y == C - 1) {
                result = jihun[x][y] + 1;
                break;
            }
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(maze[nx][ny] == '#' || jihun[nx][ny] != -1) continue;
                if(fire[nx][ny] != -1 && fire[nx][ny] <= jihun[x][y] + 1) continue;
                jihun[nx][ny] = jihun[x][y] + 1;
                escape.offer(new int[]{nx, ny});
            }
        }
        
        System.out.println(result == -1 ? "IMPOSSIBLE" : result);
    }
}
