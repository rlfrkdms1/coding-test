package hcu55.week12;

import java.io.*;
import java.util.*;

// 1의 개수 세기(prefixSum), 골드 II
public class 일의개수세기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(countOne(B) - countOne(A - 1));
    }

    public static long countOne(long x) {
        long cnt = 0;
        
        for (long pos = 1; pos <= x; pos *= 2) {
            long fullCycle = (x / (pos * 2)) * pos;
            long remain = Math.min(Math.max(x % (pos * 2) - pos + 1, 0), pos);
            cnt += fullCycle + remain;
        }
        return cnt;
    }
}
