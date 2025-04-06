import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int L = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        List<int[]> stars = new ArrayList<>();
        for(int i = 0; i < K; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            stars.add(new int[] {Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())});
        }

        int answer = 0;
        for(int[] s1 : stars) for(int[] s2 : stars) {
            int count = 0;
            for(int[] s3 : stars) if(s3[0] >= s1[0] && s3[0] <= s1[0] + L && s3[1] >= s2[1] && s3[1] <= s2[1] + L) count++;
            answer = Math.max(answer, count);
        }

        System.out.println(K - answer);
    }
}
