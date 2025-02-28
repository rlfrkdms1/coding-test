import java.util.*;
import java.io.*;

public class B20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            Map<Character, List<Integer>> alphabet = new HashMap<>();
            String word = br.readLine();
            int size = word.length();
            int K = Integer.parseInt(br.readLine());

            for(int j=0; j<size; j++) {
                char c = word.charAt(j);
                alphabet.putIfAbsent(c, new ArrayList<>());
                alphabet.get(c).add(j);
            }

            int min = Integer.MAX_VALUE;
            int max = -1;
            for(List<Integer> list:alphabet.values()) {
                int count = list.size();
                if(count < K) continue;
                for(int j=K-1; j<count; j++) {
                    int length = list.get(j) - list.get(j - K + 1) + 1;
                    min = Math.min(min, length);
                    max = Math.max(max, length);
                }
            }

            if(max == -1) sb.append("-1 ");
            else sb.append(min).append(" ").append(max);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
