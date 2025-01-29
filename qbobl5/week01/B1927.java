package qbobl5.week01;

import java.util.*;
import java.io.*;

public class B1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> hip = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(hip.isEmpty()) sb.append("0\n");
                else sb.append(hip.poll()).append("\n");
            } else hip.offer(x);
        }

        bw.append(sb.toString());
        bw.close();
    }
}