import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());

        Map<String, Integer> chars = new HashMap<>();
        String[] words = new String[size];
        int answer = 0;
        int[] answers = new int[2];
        
        for(int i = 0; i < size; i++) {
            String word = reader.readLine();
            words[i] = word;

            for(int j = 0; j <= word.length(); j++) {
                String part = word.substring(0, j);

                if(chars.containsKey(part) && (part.length() > answer || (part.length() == answer && chars.get(part) < answers[0] ))) {
                    answer = part.length();
                    answers[0] = chars.get(part);
                    answers[1] = i;
                } else chars.put(part, i);
            }
        }

        System.out.println(words[answers[0]]);
        System.out.println(words[answers[1]]);
    }
}
