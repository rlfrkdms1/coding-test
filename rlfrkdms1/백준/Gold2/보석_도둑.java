import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenzier = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenzier.nextToken());
        int K = Integer.parseInt(tokenzier.nextToken());

        int[][] jewels = new int[N][2];
        for(int i = 0; i < N; i++) {
            tokenzier = new StringTokenizer(reader.readLine());
            jewels[i][0] = Integer.parseInt(tokenzier.nextToken());
            jewels[i][1] = Integer.parseInt(tokenzier.nextToken());
        }

        int[] bag = new int[K];
        for(int i = 0; i < K; i++) bag[i] = Integer.parseInt(reader.readLine());

        Arrays.sort(bag);
        Arrays.sort(jewels, (j1, j2) -> (j1[0] - j2[0]));
        Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);

        long answer = 0;
        int i = 0;
        for(int j = 0; j < K; j++) {
            while(i < N) {
                if(jewels[i][0] > bag[j]) break;
                queue.offer(jewels[i][1]);
                i++;
            }

            if(!queue.isEmpty()) answer += queue.poll();
        }
        
        System.out.println(answer);
    }
}
