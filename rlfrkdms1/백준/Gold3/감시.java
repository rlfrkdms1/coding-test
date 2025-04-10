import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static List<int[]> cctvs = new ArrayList<>();
    static int N, M;
    static int answer = 100;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        
        int[][] office = new int[N][M];
        int k = 0;
        for(int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(tokenizer.nextToken());
                if(office[i][j] != 0 && office[i][j] != 6) cctvs.add(new int[] {i, j, office[i][j]});
            }
        }

        dfs(0, office);

        System.out.println(answer);
    }

    private static void dfs(int temp, int[][] office) {
        if(temp == cctvs.size()) {
            answer = Math.min(counting(office), answer);
            
            return;
        }

        int[] info = cctvs.get(temp++);
        int x = info[0];
        int y = info[1];
        int cctv = info[2];

        if(cctv == 5) dfs(temp, watch(x, y, Set.of(), copy(office)));
        else if(cctv == 4) {
            dfs(temp, watch(x, y, Set.of(0), copy(office)));
            dfs(temp, watch(x, y, Set.of(1), copy(office)));
            dfs(temp, watch(x, y, Set.of(2), copy(office)));
            dfs(temp, watch(x, y, Set.of(3), copy(office)));
        } else if(cctv == 3) {
            dfs(temp, watch(x, y, Set.of(0, 2), copy(office)));
            dfs(temp, watch(x, y, Set.of(0, 3), copy(office)));
            dfs(temp, watch(x, y, Set.of(1, 2), copy(office)));
            dfs(temp, watch(x, y, Set.of(1, 3), copy(office)));
        } else if(cctv == 2) {
            dfs(temp, watch(x, y, Set.of(0, 1), copy(office)));
            dfs(temp, watch(x, y, Set.of(2, 3), copy(office)));
        } else {
            dfs(temp, watch(x, y, Set.of(1, 2, 3), copy(office)));
            dfs(temp, watch(x, y, Set.of(0, 2, 3), copy(office)));
            dfs(temp, watch(x, y, Set.of(0, 1, 3), copy(office)));
            dfs(temp, watch(x, y, Set.of(0, 1, 2), copy(office)));
        }
        
    }

    private static int[][] copy(int[][] office) {
        int[][] copy = new int[N][M];
        for(int i = 0; i < N; i++) for(int j = 0; j < M; j++) copy[i][j] = office[i][j];    
        return copy;
    }

    private static int counting(int[][] office) {
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(office[i][j] == 0) count++;
            }
        } 
        return count;
    }

    private static int[][] watch(int x, int y, Set<Integer> except, int[][] office) {

        int up = x;
        int down = x;
        int right = y;
        int left = y;
        
        while(true) {
            boolean change = false;

            if(down + 1 < N && office[down + 1][y] != 6 && !except.contains(0)) {
                office[++down][y] = -1;
                change = true;
            }

            if(up - 1 >= 0 && office[up - 1][y] != 6 && !except.contains(1)) {
                office[--up][y] = -1;
                change = true;
            }

            if(right + 1 < M && office[x][right + 1] != 6 && !except.contains(2)) {
                office[x][++right] = -1;
                change = true;
            }

            if(left - 1 >= 0 && office[x][left - 1] != 6 && !except.contains(3)) {
                office[x][--left] = -1;
                change = true;
            }

            if(!change) break;
        }

        return office;
    }
}
