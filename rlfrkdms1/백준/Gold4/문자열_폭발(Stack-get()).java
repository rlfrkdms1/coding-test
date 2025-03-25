import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        String key = reader.readLine();
        int length = key.length();

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));

            if(stack.size() >= length) { //search start
                boolean find = true;
                for(int j = 0; j < length; j++) {
                    if(stack.get(stack.size() - length + j) != key.charAt(j)) {
                        find = false;
                        break;
                    }
                }
                if(find) {
                    for(int j = 0; j < length; j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        while(!stack.isEmpty()) answer.append(stack.pop());
        if(answer.length() == 0) System.out.println("FRULA");
        else System.out.println(answer.reverse().toString());
    }
}
