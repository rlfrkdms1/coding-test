import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String S = reader.readLine();
        String T = reader.readLine();

        int answer = 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(T);

        while(!queue.isEmpty() && answer == 0 && queue.peek().length() >= S.length()) {
            String text = queue.poll();

            if(text.length() == S.length()) {
                if(text.equals(S)) answer = 1;
                continue;
            }

            StringBuilder change = new StringBuilder(text);

            if(change.charAt(change.length() - 1) == 'A') {
                queue.offer(change.deleteCharAt(change.length() - 1).toString());
                change.append('A');
            }
            
            if(change.charAt(0) == 'B') queue.offer(change.deleteCharAt(0).reverse().toString());
        }
        System.out.println(answer);
    }

}
