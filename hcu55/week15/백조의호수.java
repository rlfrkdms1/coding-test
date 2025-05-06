package hcu55.week15;

import java.io.*;
import java.util.*;

// 백조의 호수(bfs+binarySearch), 플래티넘 V
public class 백조의호수 {
    static int R, C;
    static char[][] map;
    static int[][] day;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxDay = 0;
    static Point swan1, swan2;

    static class Point {
        int x, y;
        
        Point(int x, int y) { 
            this.x = x; this.y = y; 
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        day = new int[R][C];
        Queue<Point> waterQueue = new LinkedList<>();
        boolean swanFound = false;

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                
                if (map[i][j] == 'L') {
                    if (!swanFound) {
                        swan1 = new Point(i, j);
                        swanFound = true;
                    } else {
                        swan2 = new Point(i, j);
                    }
                    waterQueue.add(new Point(i, j));
                } else if (map[i][j] == '.') {
                    waterQueue.add(new Point(i, j));
                }
            }
        }

        for (int[] d : day) Arrays.fill(d, -1);
        for (Point p : waterQueue) day[p.x][p.y] = 0;

        while (!waterQueue.isEmpty()) {
            Point now = waterQueue.poll();
            
            for (int d = 0; d < 4; d++) {
                int nextX = now.x + dx[d];
                int nextY = now.y + dy[d];
                
                if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
                if (day[nextX][nextY] != -1) continue;
                if (map[nextX][nextY] == 'X') {
                    day[nextX][nextY] = day[now.x][now.y] + 1;
                    maxDay = Math.max(maxDay, day[nextX][nextY]);
                    waterQueue.add(new Point(nextX, nextY));
                }
            }
        }

        int left = 0;
        int right = maxDay;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canMeet(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean canMeet(int mid) {
        boolean[][] visited = new boolean[R][C];
        Queue<Point> queue = new LinkedList<>();
        queue.add(swan1);
        visited[swan1.x][swan1.y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            if (now.x == swan2.x && now.y == swan2.y) return true;

            for (int d = 0; d < 4; d++) {
                int nextX = now.x + dx[d];
                int nextY = now.y + dy[d];
                
                if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
                if (visited[nextX][nextY]) continue;
                if (day[nextX][nextY] <= mid) {
                    visited[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY));
                }
            }
        }

        return false;
    }
}
