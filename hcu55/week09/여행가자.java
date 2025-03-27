package hcu55.week09;

import java.io.*;
import java.util.*;

// 여행 가자(Union find), 골드 IV
public class 여행가자 {
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int connected = Integer.parseInt(st.nextToken());
                if (connected == 1) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        boolean valid = true;

        for (int i = 1; i < M; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (find(first) != find(next)) {
                valid = false;
                break;
            }
        }

        System.out.println(valid ? "YES" : "NO");
    }

    public static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) parent[pb] = pa;
    }
}
