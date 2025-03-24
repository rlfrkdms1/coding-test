import java.util.*;
import java.lang.*;
import java.io.*;

public class B2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        int[] houses = new int[N];
        for(int i=0; i<N; i++) houses[i] = Integer.parseInt(br.readLine());
        Arrays.sort(houses);

        int min = 1;
        int max = houses[N - 1] - houses[0];
        int distance = 0;
        if(C == 2) {
            System.out.println(max);
            System.exit(0);
        }
        
        while(min <= max) {
            int mid = (min + max) / 2;
            int count = 1;
            int location = houses[0];
            boolean flag = false;
            for(int i=1; i<N; i++) {
                if(houses[i] - location >= mid) {
                    location = houses[i];
                    count ++;
                }
                if(count >= C) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                distance = mid;
                min = mid + 1;
            } else max = mid - 1;
        }

        System.out.println(distance);
    }
}
