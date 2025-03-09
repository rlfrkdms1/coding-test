import java.io.*;
import java.util.*;

public class B2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = N - 1;
        int sum = Integer.MAX_VALUE;
        int[] result = new int[2];

        while(left < right) {
            int temp = arr[left] + arr[right];
            if(Math.abs(temp) < sum) {
                sum = Math.abs(temp);
                result[0] = arr[left];
                result[1] = arr[right];
            }
            if(temp < 0) left ++;
            else right --;
        }

        System.out.println(result[0] + " " + result[1]);
    }
}
