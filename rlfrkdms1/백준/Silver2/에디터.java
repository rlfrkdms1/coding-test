import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        String text = reader.readLine();
        for(int i = 0; i < text.length(); i++) {
            left.push(text.charAt(i));
        }
        
        int commands = Integer.parseInt(reader.readLine());
        for(int i = 0; i < commands; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();
            if(command.equals("L") && !left.isEmpty()) right.push(left.pop());
            if(command.equals("D") && !right.isEmpty()) left.push(right.pop());
            if(command.equals("B") && !left.isEmpty()) left.pop();
            if(command.equals("P")) left.push(tokenizer.nextToken().charAt(0));
        }

        while(!left.isEmpty()) {
            right.push(left.pop());
        }

        while(!right.isEmpty()) {
            writer.write(right.pop());
        }
        
        writer.flush();   
        writer.close();
    }
}
