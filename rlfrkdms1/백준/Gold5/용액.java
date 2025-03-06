import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        long[] liquids = new long[size];
        for(int i = 0; i < size; i++) {
            liquids[i] = Long.parseLong(tokenizer.nextToken());
        }

        long[] answer = {0, 0, Integer.MAX_VALUE};

        int left = 0;
        int right = size - 1;
        while(left != right) {
            long sum = liquids[left] + liquids[right];
            if(Math.abs(0 - sum) < answer[2]) answer = new long[] {left, right, Math.abs(0 - sum)};
            if(sum > 0) right--;
            else left++;
        }
        
        System.out.println(liquids[(int) answer[0]] + " " + liquids[(int) answer[1]]);
    }
}
