package qbobl5.week02;

import java.util.*;
import java.io.*;

public class B1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        result[Integer.parseInt(st.nextToken())] = 1;
        for(int i=2; i<=N; i++) {
            int count = Integer.parseInt(st.nextToken());
            for(int j=0; j<N; j++) {
                if(result[j] == 0) {
                    if(count == 0) {
                        result[j] = i;
                        break;
                    }
                    count --;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) sb.append(result[i]).append(" ");
        System.out.println(sb);
    }
}