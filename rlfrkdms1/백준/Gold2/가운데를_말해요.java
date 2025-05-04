import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        Queue<Integer> left = new PriorityQueue<>((n1, n2) -> n2 - n1);
        Queue<Integer> right = new PriorityQueue<>((n1, n2) -> n1 - n2);
        int size1 = 0;
        int size2 = 0;
        int mid = 0;
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(reader.readLine());    
            if(i == 0) {
                mid = number;
            } else if(number <= mid) {
                if(size1 < size2) {
                    left.offer(number);
                    size1++;
                } else {
                    right.offer(mid);
                    size2++;
                    left.offer(number);
                    mid = left.poll();
                } 
            } else {
                if(size2 <= size1) {
                    right.offer(number);
                    size2++;
                } else {
                    left.offer(mid);
                    size1++;
                    right.offer(number);
                    mid = right.poll();
                }
            }
            answer.append(mid).append("\n");
        }

        System.out.println(answer.toString());
    }
}
