import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int d = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());

        int[] sushi = new int[N];
        for(int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(reader.readLine());
        }

        Map<Integer, Integer> picks = new HashMap<>();
        for(int i = 0; i < k; i++) {
            picks.put(sushi[i], picks.getOrDefault(sushi[i], 0) + 1);
        }

        int answer = picks.containsKey(c) ? picks.size() : picks.size() + 1;
        
        for(int i = 0; i < N; i++) {
            //remove
            if(picks.get(sushi[i]) == 1) picks.remove(sushi[i]);
            else picks.put(sushi[i], picks.get(sushi[i]) - 1);

            //put
            int pick = sushi[(i + k) % N];
            picks.put(pick, picks.getOrDefault(pick, 0) + 1);

            answer = Math.max(answer, picks.containsKey(c) ? picks.size() : picks.size() + 1);
        }

        System.out.println(answer);
        
    }
}
