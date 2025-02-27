import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] board = new int[101];

        for(int i=1; i<101; i++) board[i] = i;
        for(int i=0; i<N+M; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {1, 0});
        board[1] = 0;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            if(current[0] == 100) {
                System.out.println(current[1]);
                break;
            }

            for(int i=1; i<7; i++) {
                int next = current[0] + i;
                if(next > 100 || board[next] == 0) continue;
                next = board[next];
                board[next] = 0;
                queue.add(new int[] {next, current[1] + 1});
            }
        }
    }
}
