import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();

        int totalA = 0;
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == 'a') totalA++;
        }

        int answer = 0;
        for(int i = 0; i < totalA; i++) {
            if(text.charAt(i) == 'b') answer++;
        }

        int b = answer;
        for(int i = 1; i < text.length(); i++) {
            if(text.charAt(i - 1) == 'b') b--;
            if(text.charAt((i + totalA - 1)%text.length()) == 'b') b++;
            answer = Math.min(answer, b);
        }

        System.out.println(answer);
        
    }
}
