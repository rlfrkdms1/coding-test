import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        
        int[] numbers = new int[size];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < size; i++) numbers[i] = Integer.parseInt(tokenizer.nextToken());
        Arrays.sort(numbers);

        Set<Integer> likes = new HashSet<>();
        for(int i = 0; i < size; i++) {

            if(likes.contains(numbers[i])) continue;

            int left = 0 == i ? 1 : 0;
            int right = size - 1 == i ? size - 2 : size - 1;
            while(left < right) {
                int sum = numbers[left] + numbers[right];
                
                if(sum == numbers[i]) {
                    likes.add(numbers[i]);
                    break;
                }

                if(sum > numbers[i] && --right == i) right--;
                if(sum < numbers[i] && ++left == i) left++;
            }
        }

        int answer = 0;
        for(int number : numbers) {
            if(likes.contains(number)) answer++;
        }
        
        System.out.println(answer);
    }
}
