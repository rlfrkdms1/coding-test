import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int s = Integer.parseInt(tokenizer.nextToken());

        int[] numbers = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        int left = 0;
        int right = -1;
        for(int i = 0; i < n; i++) {
            if(i == 0) numbers[i] = Integer.parseInt(tokenizer.nextToken());
            else numbers[i] = Integer.parseInt(tokenizer.nextToken()) + numbers[i - 1];

            if(right == -1 && numbers[i] >= s) right = i;
        }
 
        int answer = right + 1;
        while(left <= right && right < n) {
            if(numbers[right] - numbers[left] >= s) answer = Math.min(answer, right - left++);
            else right++;
        }

        System.out.println(answer);
    }
}
