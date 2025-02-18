package qbobl5.week04;

import java.util.*;
import java.io.*;

public class B1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] way = new int[100001];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        way[N] = 1;

        while(!queue.isEmpty()) {
            N = queue.poll();
            int count = way[N] + 1;

            int right = N + 1;
            if(N < 100000 && way[right] == 0) {
                way[right] = count;
                queue.add(right);
            }

            int left = N - 1;
            if(N > 0 && way[left] == 0) {
                way[left] = count;
                queue.add(left);
            }

            int telpo = 2 * N;
            if(N <= 50000 && way[telpo] == 0) {
                way[telpo] = count;
                queue.add(telpo);
            }
        }

        System.out.println(way[K] - 1);
    }
}