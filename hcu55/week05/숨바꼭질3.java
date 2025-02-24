package hcu55.week05;

import java.io.*;
import java.util.*;

// 숨바꼭질 3(graph), 골드 V
public class 숨바꼭질3 {
    static int N, K;
    static int[] arr = new int[100001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N, K);
        }
    }

    public static void bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        Arrays.fill(arr, -1);
        arr[n] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == k) {
                System.out.println(arr[now]);
                return;
            }

            int next = now * 2;
            if (next < arr.length && arr[next] == -1) {
                queue.add(next);
                arr[next] = arr[now];
            }

            next = now - 1;
            if (next >= 0 && arr[next] == -1) {
                queue.add(next);
                arr[next] = arr[now] + 1;
            }

            next = now + 1;
            if (next < arr.length && arr[next] == -1) {
                queue.add(next);
                arr[next] = arr[now] + 1;
            }
        }
    }
}
