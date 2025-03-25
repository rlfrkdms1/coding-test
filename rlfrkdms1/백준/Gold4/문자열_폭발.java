import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        char[] text = reader.readLine().toCharArray();
        char[] bomb = reader.readLine().toCharArray();

        Stack<Character> chars = new Stack<>();
        for(int i = text.length - 1; i >= 0; i--) {
            chars.push(text[i]);
            
            int j = 0;
            while(!chars.isEmpty() && j < bomb.length && chars.peek() == bomb[j]) {
                chars.pop();
                j++;
            }
            if(j != bomb.length) {
                for(int k = j - 1; k >= 0; k--) chars.push(bomb[k]);
            }
            
        }

        StringBuilder answer = new StringBuilder();
        while(!chars.isEmpty()) answer.append(chars.pop());

        System.out.println(answer.length() == 0 ? "FRULA" : answer.toString());
    }
}
