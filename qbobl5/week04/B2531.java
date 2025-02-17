package qbobl5.week04;

import java.util.*;
import java.io.*;

public class B2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        int[] ate = new int[d + 1];
        for(int i=0; i<N; i++) sushi[i] = Integer.parseInt(br.readLine());

        int count = 0;
        boolean flag = false;
        for(int i=0; i<k; i++) {
            if(ate[sushi[i]] == 0) count ++;
            ate[sushi[i]] ++;
        }

        if(ate[c] == 0) {
            count ++;
            flag = true;
        }

        int max = count;
        for(int i=1; i<N; i++) {
            ate[sushi[i - 1]] --;
            if(ate[sushi[i - 1]] == 0) count --;
            if(ate[sushi[(i + k - 1) % N]] == 0) count ++;
            ate[sushi[(i + k - 1) % N]] ++;
            if(ate[c] == 0 && !flag) {
                count ++;
                flag = true;
            } else if(ate[c] != 0 && flag) {
                count --;
                flag = false;
            }
            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}