package qbobl5.week02;

import java.util.*;
import java.io.*;

public class B2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> hip = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) hip.offer(Integer.parseInt(st.nextToken()));
        }
        for(int i=1; i<N; i++) hip.poll();
        System.out.println(hip.poll());
    }
}