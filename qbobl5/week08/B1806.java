import java.util.*;
import java.io.*;

public class B1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) numbers[i] = Integer.parseInt(st.nextToken());

        int p1 = 1;
        int p2 = 1;
        int count = 1;
        int sum = numbers[1];
        int min = Integer.MAX_VALUE;
        while(p1 <= N) {
            if(sum >= S) {
                min = Math.min(min, count);
                sum -= numbers[p1];
                p1 ++;
                count --;
            } else if(p2 < N) {
                p2 ++;
                sum += numbers[p2];
                count ++;
            } else break;
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
