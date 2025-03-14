import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static List<int[]> union = new ArrayList<>();
    static int sum = 0;
    static boolean[][] visited;
    static int[][] map;
    static int N, L, R;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        L = Integer.parseInt(tokenizer.nextToken());
        R = Integer.parseInt(tokenizer.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < N; j ++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int days = 0;
        while(true) {
            visited = new boolean[N][N];
            boolean moved = false;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j ++) {
                    if(!visited[i][j]) {
                        visited[i][j] = true;
                        sum += map[i][j];
                        union.add(new int[] {i, j});
                        find(i, j);
                        if(union.size() > 1) moved = true;
                        move();
                    }
                }
            }
            if(!moved) break;

            days++;
        }
        
        System.out.println(days);
    }

    private static void move() {
        int population = sum / union.size();
        for(int i = 0; i < union.size(); i++) {
            int[] target = union.get(i);
            map[target[0]][target[1]] = population;
        }
        sum = 0;
        union.clear();
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    private static void find(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(tx >= 0 && tx < N && ty >= 0 && ty < N && !visited[tx][ty] &&
               (int) Math.abs(map[x][y] - map[tx][ty]) <= R && (int) Math.abs(map[x][y] - map[tx][ty]) >= L) {
                visited[tx][ty] = true;
                sum += map[tx][ty];
                union.add(new int[] {tx, ty});
                find(tx, ty);
            }
        }
    }
}
