package qbobl5.week01;
import java.util.*;
import java.io.*;

public class B22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) map.put(br.readLine(), 1);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            String[] blogKewords = br.readLine().split(",");
            for(String keyword:blogKewords) map.remove(keyword);
            sb.append(map.size()).append("\n");
        }

        bw.append(sb.toString());
        bw.close();
    }
}