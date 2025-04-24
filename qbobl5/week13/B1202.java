import java.io.*;
import java.util.*;

public class B1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] jewel = new int[N][2];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            jewel[i][0] = Integer.parseInt(st.nextToken());
            jewel[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] bag = new int[K];
        for(int i=0; i<K; i++) bag[i] = Integer.parseInt(br.readLine());

        Arrays.sort(jewel, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0;
        int index = 0;
        for(int i : bag) {
            while(index < N && i >= jewel[index][0]) pq.offer(jewel[index++][1]);
            if(!pq.isEmpty()) sum += pq.poll();
        }

        System.out.println(sum);
    }
}
