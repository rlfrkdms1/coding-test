import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());

        Map<Integer, Integer> index = new HashMap<>();
        int[] numbers = new int[size];
        
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int duplication = 0;
        long answer = 0;
        int left = 0;
        for(int i = 0; i < size; i++) {
            int number = Integer.parseInt(tokenizer.nextToken());
            if(index.containsKey(number)) {
                answer += ((long) index.size() * (long)(index.size() + 1)) / 2 - duplication;
                duplication = (i - index.get(number) - 1) * (i - index.get(number)) / 2;
                for(int j = left; j < index.get(number); j++) index.remove(numbers[j]);
                left = index.get(number) + 1;
            } 
            numbers[i] = number;
            index.put(number, i);
        }

        System.out.println(answer + ((long)index.size() * ((long)index.size() + 1)) / 2 - duplication);
    }
}
