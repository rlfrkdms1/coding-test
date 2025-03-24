import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int C = Integer.parseInt(tokenizer.nextToken());

        int[] houses = new int[N];
        for(int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(houses);

        int left = 1;
        int right = houses[N - 1];
        int answer = 0;
        while(left <= right) {
            int mid = (left + right) / 2;

            int count = 1;
            int ex = houses[0];
            for(int i = 0; i < N; i++) {
                if(houses[i] - ex >= mid) {
                    count++;
                    ex = houses[i];
                }
            }

            if(count >= C) {
                left = mid + 1;
                answer = Math.max(mid, answer);
            } else right = mid - 1;
         }

        System.out.println(answer);
    }
}
