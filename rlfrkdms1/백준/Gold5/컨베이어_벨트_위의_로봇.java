import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    static Deque<int[]> top = new ArrayDeque<>();
    static Deque<int[]> bottom = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());

        for(int i = 0; i < n; i++) {
            top.offer(new int[] {Integer.parseInt(tokenizer.nextToken()), 0});
        }

        for(int i = 0; i < n; i++) {
            bottom.offerFirst(new int[] {Integer.parseInt(tokenizer.nextToken()), 0});
        }

        int count0 = 0;
        int step = 0;
        while(count0 < k) {
            step++;
            
            //1
            bottom.offerLast(top.pollLast());
            top.offerFirst(bottom.pollFirst());

            getOffRobot();
            
            //2
            for(int i = 0; i < n; i++) {
                int[] target = top.pollLast();
                int[] preTarget = top.peekFirst();
                if(target[1] == 1 && preTarget[0] > 0 && preTarget[1] == 0) {
                    target[1] = 0;
                    preTarget[1] = 1;
                    if(--preTarget[0] == 0) count0++;   
                }
                top.offerFirst(target);
            }
            getOffRobot();
            
            //3
            int[] up = top.peekFirst();
            if(up[0] > 0) {
                if(--up[0] == 0) count0++;
                up[1] = 1;
            }
            
        }
        System.out.println(step);
    }

    static void getOffRobot() {
        int[] last = top.peekLast();
        last[1] = 0;
    }

}
