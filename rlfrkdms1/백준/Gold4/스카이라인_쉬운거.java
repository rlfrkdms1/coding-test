import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        int answer = 0;
        Stack<Integer> lines = new Stack<>();
        for(int i = 0; i < size; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int position = Integer.parseInt(tokenizer.nextToken());
            int length = Integer.parseInt(tokenizer.nextToken());

            if(lines.isEmpty()) lines.push(length);
            else {
                if(length > lines.peek()) lines.push(length);
                if(length < lines.peek()) {
                    while(!lines.isEmpty() && lines.peek() > length) {
                        lines.pop();
                        answer++;
                    }

                    if(!lines.isEmpty() && lines.peek() == length) continue;
                    lines.push(length);
                }
            }
        }

        while(!lines.isEmpty()) {
            if(lines.pop() != 0) answer++;
        }

        System.out.println(answer);
    }
}
