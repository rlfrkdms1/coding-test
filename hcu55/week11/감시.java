package hcu55.week11;

import java.io.*;
import java.util.*;

// 감시(dfs+impl), 골드 III
public class 감시 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> cctvList = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][][] cctvDir = {
        {},
        {{0}, {1}, {2}, {3}},
        {{0, 1}, {2, 3}},
        {{0, 2}, {2, 1}, {1, 3}, {3, 0}},
        {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
        {{0, 1, 2, 3}}
    };
    static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) cctvList.add(new int[]{i, j, map[i][j]});
            }
        }

        dfs(0, map);
        System.out.println(min);
    }

    public static void dfs(int depth, int[][] map) {
        if (depth == cctvList.size()) {
            countBlind(map);
            return;
        }

        int[] cctv = cctvList.get(depth);
        int x = cctv[0];
        int y = cctv[1];
        int type = cctv[2];

        for (int[] dir : cctvDir[type]) {
            int[][] copyMaps = copyMap(map);
            for (int d : dir) {
                watch(x, y, d, copyMaps);
            }
            dfs(depth + 1, copyMaps);
        }
    }

    public static void watch(int x, int y, int d, int[][] map) {
        while (true) {
            x += dx[d];
            y += dy[d];

            if (x < 0 || x >= N || y < 0 || y >= M) break;
            if (map[x][y] == 6) break;
            if (map[x][y] == 0) map[x][y] = -1;
        }
    }

    public static void countBlind(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        min = Math.min(min, count);
    }

    public static int[][] copyMap(int[][] map) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }
}
