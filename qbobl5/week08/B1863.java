import java.util.*;
import java.io.*;

public class B1863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        
        for(; N>0; N--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int height = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peek() > height) {
                stack.pop();
                count ++;
            }
            if(!stack.isEmpty() && stack.peek() == height) continue;
            stack.push(height);
        }

        for(int i:stack) if(i != 0) count ++;
        System.out.println(count);
    }
}
