import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] left = new int[size];
        for(int i = 0; i < size; i++) {
            left[i] = Integer.parseInt(tokenizer.nextToken());
        }

        List<Integer> persons = new LinkedList<>();
        persons.add(size);
        for(int i = size - 2; i >= 0; i--) {
            int count = left[i];
            int j = 0;
            while(count != 0) {
                if(persons.get(j) > i + 1) count--;
                j++;
            }
            persons.add(j, i + 1);
        }
        
        StringJoiner joiner = new StringJoiner(" ");
        for(int i = 0; i < size; i++) {
            joiner.add(String.valueOf(persons.get(i)));
        }

        System.out.println(joiner.toString());
    }
}
