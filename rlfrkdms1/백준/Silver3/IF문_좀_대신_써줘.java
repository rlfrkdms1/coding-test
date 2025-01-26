import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int ranks = Integer.parseInt(tokenizer.nextToken());
        int players = Integer.parseInt(tokenizer.nextToken());

        String[] titles = new String[ranks];
        int[] powers = new int[ranks];
        for(int i = 0; i < ranks; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            titles[i] = tokenizer.nextToken();
            powers[i] = Integer.parseInt(tokenizer.nextToken());
        }
    
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        for(int i = 0; i < players; i++) {
            int power = Integer.parseInt(reader.readLine());
            int left = 0;
            int right = powers.length - 1;
            while(left <= right) {
                int mid = (left + right) / 2;
                if(powers[mid] < power) left = mid + 1;
                else right = mid - 1;
            }
            joiner.add(titles[left]);
        }

        System.out.println(joiner.toString());
    }
}
