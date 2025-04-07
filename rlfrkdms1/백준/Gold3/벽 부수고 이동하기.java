import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        boolean[][][] visited = new boolean[n][m][2];
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++) {
            String line = reader.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, false, 1));
        visited[0][0][0] = true;

        boolean find = false;
        while(!queue.isEmpty()) {
            Point point = queue.poll();

            if(point.x == n - 1 && point.y == m - 1) {
                System.out.println(point.value);
                find = true;
                break;
            }

            for(int i = 0; i < 4; i++) {
                int tx = point.x + dx[i];
                int ty = point.y + dy[i];

                if(tx >= 0 && tx < n && ty >= 0 && ty < m) {
                    if(point.destroyed) { // 이미 벽을 뚫은 것이라면
                        if(map[tx][ty] == 0 && !visited[tx][ty][1]) {
                            queue.offer(new Point(tx, ty, true, point.value + 1));
                            visited[tx][ty][1] = true;
                        }
                    } else { // 벽을 뚫지 않은 것
                        if(map[tx][ty] == 0 && !visited[tx][ty][0]) {
                            queue.offer(new Point(tx, ty, false, point.value + 1));
                            visited[tx][ty][0] = true;
                        } else if(map[tx][ty] == 1){ // 뚫기
                            queue.offer(new Point(tx, ty, true, point.value + 1));
                            visited[tx][ty][1] = true;
                        }
                    }
                }
            }
        }
        
        if(!find) System.out.println(-1);
    }

    static class Point {
        int x;
        int y;
        boolean destroyed;
        int value;

        public Point(int x, int y, boolean destroyed, int value) {
            this.x = x;
            this.y = y;
            this.destroyed = destroyed;
            this.value = value;
        }

    }

}
