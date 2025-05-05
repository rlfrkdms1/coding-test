import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static int R, C;
    private static boolean[][] visited1, visited2, map;
    private static int[][] swans;
    
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        visited1 = new boolean[R][C];
        visited2 = new boolean[R][C];
        map = new boolean[R][C];
        swans = new int[2][2];
        for(int i = 0; i < R; i++) {
            String input = reader.readLine();
            for(int j = 0; j < C; j++) {
                char target = input.charAt(j);
                if(target == 'L') {
                    if(swans[0][0] == 0 && swans[0][1] == 0) swans[0] = new int[] {i, j};
                    else swans[1] = new int[] {i, j};
                    map[i][j] = true;
                } else if(target == '.') map[i][j] = true;
                else map[i][j] = false;
            }
        }

        Queue<int[]> melt = new LinkedList<>();
        
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(!map[i][j]) {
                    for(int k = 0; k < 4; k++) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];

                        if(tx >= 0 && tx < R && ty >= 0 && ty < C && map[tx][ty] && !visited2[i][j]) {
                            visited2[i][j] = true;
                            melt.offer(new int[] {i, j});
                        }
                    }
                }
            }
        }

        System.out.println(go(melt));
    }

    private static int go(Queue<int[]> melt) {
        int count = 0;
        Queue<int[]> swan = new LinkedList<>();
        Queue<int[]> waitSwan = new LinkedList<>();
        Queue<int[]> waitMelt = new LinkedList<>();
        swan.offer(swans[0].clone());
        visited1[swans[0][0]][swans[0][1]] = true;
        while(!swan.isEmpty() && !melt.isEmpty()) {

            while(!swan.isEmpty()) {
                int[] temp = swan.poll();
                if(temp[0] == swans[1][0] && temp[1] == swans[1][1]) return count;
                for(int i = 0; i < 4; i++) {
                    int tx = temp[0] + dx[i];
                    int ty = temp[1] + dy[i];

                    if(tx >= 0 && tx < R && ty >= 0 && ty < C && !visited1[tx][ty]) {
                        visited1[tx][ty] = true;
                        if(map[tx][ty]) swan.offer(new int[] {tx, ty});
                        else waitSwan.offer(new int[] {tx, ty});
                    }
                }
            }

            while(!waitSwan.isEmpty()) swan.offer(waitSwan.poll());

            while(!melt.isEmpty()) {
                int[] temp = melt.poll();
                map[temp[0]][temp[1]] = true;

                for(int i = 0; i < 4; i++) {
                    int tx = temp[0] + dx[i];
                    int ty = temp[1] + dy[i];

                    if(tx >= 0 && tx < R && ty >= 0 && ty < C && !visited2[tx][ty] && !map[tx][ty]) {
                        visited2[tx][ty] = true;
                        waitMelt.offer(new int[] {tx, ty});
                    }
                }
            }

            while(!waitMelt.isEmpty()) melt.offer(waitMelt.poll());
            count++;
        }

        return count;
    }
}
