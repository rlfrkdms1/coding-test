import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        int[] numbers = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Map<Integer, List<Integer>> sequence = new HashMap<>();
        int answer = 0;
        int count = 0;
        for(int i = 0; i < n; i++) {
            List<Integer> duplications = sequence.getOrDefault(numbers[i], new ArrayList<>());
            duplications.add(i);
            if(!sequence.containsKey(numbers[i])) {
                sequence.put(numbers[i], duplications);
            }
            if(duplications.size() > k) {
                answer = Math.max(answer, count);
                i = duplications.get(0);
                sequence.clear();
                count = 0;
            } else {
                count++;
            }
        }
        answer = Math.max(answer, count);
        System.out.println(answer);
    }
}
