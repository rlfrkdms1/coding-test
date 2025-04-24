import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        Map<Integer, List<long[]>> paths = new HashMap<>();
        for(int i = 1; i <= N; i++) paths.put(i, new ArrayList<>());
        
        for(int i = 1; i <= M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int A = Integer.parseInt(tokenizer.nextToken());
            int B = Integer.parseInt(tokenizer.nextToken());
            
            paths.get(A).add(new long[] {B, i});
            paths.get(B).add(new long[] {A, i});
        }

        long[] times = new long[N + 1];
        Arrays.fill(times, Long.MAX_VALUE);
        times[1] = 0;

        Queue<long[]> queue = new PriorityQueue<>((n1, n2) -> Long.compare(n1[1], n2[1]));
        queue.offer(new long[] {1, 0});
        while(!queue.isEmpty()) {
            long[] temp = queue.poll();

            if(times[(int) temp[0]] != temp[1]) continue;
            
            for(long[] path : paths.get((int) temp[0])) {
                if(temp[1] > path[1]) path[1] += ((long) Math.ceil((double) (temp[1] - path[1]) / M)) * M;
                if(times[(int) path[0]] > path[1]) {
                    queue.offer(path.clone());
                    times[(int)path[0]] = path[1];
                }
            }
        }

        System.out.println(times[N]);

    }
}
