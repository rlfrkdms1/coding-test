package hcu55.week04;

import java.io.*;
import java.util.*;

// 숨바꼭질(bfs), 실버 I
public class 숨바꼭질 {
    static int N, K;
    static int[] arr = new int[100001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) System.out.println(0); 
        else bfs(N);
    }

    public static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        arr[n] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) {
                System.out.println(arr[now] - 1);
                return;
            }
            
            for (int i = 0; i < 3; i++) {
                if (i == 0 && now + 1 < arr.length && arr[now + 1] == 0) {
                    arr[now + 1] = arr[now] + 1;
                    queue.add(now + 1);
                }
                if (i == 1 && now - 1 >= 0 && arr[now - 1] == 0) {
                    arr[now - 1] = arr[now] + 1;
                    queue.add(now - 1);
                }
                if (i == 2 && now * 2 < arr.length && arr[now * 2] == 0) {
                    arr[now * 2] = arr[now] + 1;
                    queue.add(now * 2);
                }
            }
        }
    }
}
