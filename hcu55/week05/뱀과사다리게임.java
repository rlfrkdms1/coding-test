package hcu55.week05;

import java.io.*;
import java.util.*;

// 뱀과 사다리 게임(bfs), 골드 V
public class 뱀과사다리게임 {
    static int[] board = new int[101];
    static boolean[] visited = new boolean[101];
    static Map<Integer, Integer> ladder = new HashMap<>(); 
    static Map<Integer, Integer> snake = new HashMap<>(); 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            ladder.put(start, end);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            snake.put(start, end);
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int position = now[0];
            int count = now[1];

            if (position == 100) {
                return count;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = position + dice;

                if (next <= 100 && !visited[next]) {
                    if (ladder.containsKey(next)) {
                        next = ladder.get(next);
                    }
    
                    if (snake.containsKey(next)) {
                        next = snake.get(next);
                    }
    
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(new int[]{next, count + 1});
                    }
                }
            }
        }
        return 0;
    }
}
