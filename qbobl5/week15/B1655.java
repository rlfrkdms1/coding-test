import java.io.*;
import java.util.*;

public class B1655 { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> minHip = new PriorityQueue<>();
        Queue<Integer> maxHip = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<N; i++) {
            int number = Integer.parseInt(br.readLine());
            if(minHip.size() == maxHip.size()) {
                minHip.offer(number);
                maxHip.offer(minHip.poll());
            } else {
                maxHip.offer(number);
                minHip.offer(maxHip.poll());
            }
            sb.append(maxHip.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
