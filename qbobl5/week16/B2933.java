import java.io.*;
import java.util.*;

public class B2933 {
    static int R, C, N;
    static char[][] cave;
    static boolean[][] visited;
    static int[] height;
    static int[][] dir = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    static class Node {
        int r;
        int c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        cave = new char[R][C];

        for(char[] temp:cave) Arrays.fill(temp, '.');
        for(int i=0; i<R; i++) {
            String input = br.readLine();
            for(int j=0; j<C; j++) cave[i][j] = input.charAt(j);
        }

        N = Integer.parseInt(br.readLine());
        height = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) height[i] = R - Integer.parseInt(st.nextToken());
        
        for(int i=0; i<N; i++) {
            remove(i, height[i]);
            check();
            fall();
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) sb.append(cave[i][j]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void remove(int turn, int height) {
        if(turn % 2 == 0) {
            for(int i=0; i<C; i++) {
                if(cave[height][i] == 'x') {
                    cave[height][i] = '.';
                    return;
                }
            }
        } else {
            for(int i=C-1; i>=0; i--) {
                if(cave[height][i] == 'x') {
                    cave[height][i] = '.';
                    return;
                }
            }
        }
    }

    static void check() {
        visited = new boolean[R][C];
        for(int i=0; i<C; i++) {
            if(cave[R-1][i] == 'x' && !visited[R-1][i]) {
                Node start = new Node(R-1, i);
                ArrayDeque<Node> dq = new ArrayDeque<>();
                visited[start.r][start.c] = true;
                dq.add(start);

                while(!dq.isEmpty()) {
                    Node current = dq.poll();
                    for(int j=0; j<4; j++) {
                        int nextR = current.r + dir[j][0];
                        int nextC = current.c + dir[j][1];
                        if(indexCheck(nextR, nextC) && !visited[nextR][nextC] && cave[nextR][nextC] == 'x') {
                            visited[nextR][nextC] = true;
                            dq.add(new Node(nextR, nextC));
                        }
                    }
                }
            }
        }
    }

    static void fall() {
        Set<Node> set = new HashSet<>();
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(cave[i][j] == 'x' && !visited[i][j]) {
                    cave[i][j] = '.';
                    set.add(new Node(i,j));
                }
            }
        }
        
        if(set.isEmpty()) return;
        boolean flag = true;
        
        while(flag) {
            for(Node current:set) {
                if(!indexCheck(current.r + 1, current.c) || cave[current.r + 1][current.c] == 'x') {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                for(Node current:set) current.r++;
            }
        }

        for(Node current:set) cave[current.r][current.c] = 'x';
    }

    static boolean indexCheck(int row, int col) {
        return (row >= 0 && col >= 0 && row < R && col < C);
    }
}
