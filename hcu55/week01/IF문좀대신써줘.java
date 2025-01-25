package hcu55.week01;

import java.io.*;
import java.util.*;

// IF문 좀 대신 써줘(map), 실버 III
public class IF문좀대신써줘 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        TreeMap<Integer, String> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String tier = st.nextToken();
            int power = Integer.parseInt(st.nextToken());

            if (!map.containsKey(power)) {
                map.put(power, tier);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int power = Integer.parseInt(br.readLine());
            sb.append(map.ceilingEntry(power).getValue()).append("\n");
        }

        System.out.print(sb);
    }
}
