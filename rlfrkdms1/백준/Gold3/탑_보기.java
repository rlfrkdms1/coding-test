import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] buildings = new int[N + 1];
        int[][] answer = new int[N + 1][2];
        
        for(int i = 1 ; i <= N ; i ++) {
            buildings[i] = Integer.parseInt(tokenizer.nextToken());
            answer[i][1] = -100000;
        }


        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i <= N; i++) {
            while(!stack.isEmpty() && buildings[i] >= buildings[stack.peek()]) stack.pop();
            answer[i][0] = stack.size();
            if(stack.size() > 0) answer[i][1] = stack.peek();
            stack.push(i);
        }
        
        stack = new Stack<>();
        for(int i = N; i > 0; i--) {
            while(!stack.isEmpty() && buildings[i] >= buildings[stack.peek()]) stack.pop();
            answer[i][0] += stack.size();
            if(stack.size() > 0 && i - answer[i][1] > stack.peek() - i) answer[i][1] = stack.peek();
            stack.push(i);
        }

        StringBuilder print = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            print.append(answer[i][0]);
            if(answer[i][0] != 0) print.append(" ").append(answer[i][1]);
            print.append("\n");
        }

        System.out.println(print.toString());
    }
}
