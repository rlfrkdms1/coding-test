import java.util.*;
import java.io.*;

public class B13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) numbers[i] = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        int end = 0;
        long count = 0;
        
        for(int i=0; i<N; i++) {
            while(end < N && !set.contains(numbers[end])) {
                set.add(numbers[end]);
                end ++;
            }
            set.remove(numbers[i]);
            count += (end - i);
        }
        
        System.out.println(count);
    }
}
