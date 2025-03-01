import java.io.*;
import java.util.*;

public class B2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int topCount = Integer.parseInt(br.readLine());
        int[] tops = new int[topCount];

        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<topCount; i++) tops[i] = Integer.parseInt(st.nextToken());
        
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {topCount - 1, tops[topCount - 1]});
        
        for(int i=topCount-2; i>=0; i--) {
            while(!stack.isEmpty()) {
                int[] current = stack.peek();
                if(current[1] > tops[i]) break;
                tops[current[0]] = i + 1;
                stack.pop();
            }
            stack.push(new int[] {i, tops[i]});
        }

        while(!stack.isEmpty()) {
            int[] current = stack.pop();
            tops[current[0]] = 0;
        }

        StringBuilder sb = new StringBuilder();
        for(int top:tops) sb.append(top).append(" ");
        System.out.println(sb);
    }
}
