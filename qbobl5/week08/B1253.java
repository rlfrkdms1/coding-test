import java.util.*;
import java.io.*;

public class B1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) numbers[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(numbers);
        int count = 0;
        for(int i=0; i<N; i++) {
            int left = 0;
            int right = N - 1;

            while(left < right) {
                if(i == left) {
                    left ++;
                    continue;
                }
                if(i == right) {
                    right --;
                    continue;
                }

                int sum = numbers[left] + numbers[right];
                if(numbers[i] == sum) {
                    count ++;
                    break;
                }

                if(numbers[i] > sum) left ++;
                else right --;
            }
        }
        System.out.println(count);
    }
}
