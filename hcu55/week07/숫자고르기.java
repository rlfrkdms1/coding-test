package hcu55.week07;

import java.io.*;
import java.util.*;

// 숫자고르기(graph), 골드 V
public class 숫자고르기 {
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i, i);
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (int num : list) {
            System.out.println(num);
        }
    }

    static void dfs(int start, int current) {
        if (visited[current]) {
            if (current == start) {
                list.add(start);
            }
            return;
        }

        visited[current] = true;
        dfs(start, arr[current]);
    }
}
