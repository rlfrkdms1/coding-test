import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int[] counts = new int[size+1];
        Stack<int[]> top = new Stack<>();
        for(int i = 0; i < size; i++) {
            top.push(new int[] {i+1, Integer.parseInt(tokenizer.nextToken())});
        }

        StringJoiner answer = new StringJoiner(" ");
        Stack<int[]> last = new Stack<>();

        while(!top.isEmpty()) {
            if(last.isEmpty()) last.push(top.pop());
            else {
                int[] target = top.pop();
                while(!last.isEmpty() && target[1] > last.peek()[1]) counts[last.pop()[0]] = target[0];
                last.push(target);
            }
        }

        while(!last.isEmpty()) counts[last.pop()[0]] = 0;
        for(int i = 1; i < size + 1; i++) answer.add(String.valueOf(counts[i])); 
        
        System.out.println(answer.toString());
        
    }
}
