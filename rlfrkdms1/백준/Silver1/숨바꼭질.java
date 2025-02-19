import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int subin = Integer.parseInt(tokenizer.nextToken());
        int brother = Integer.parseInt(tokenizer.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[brother + 2];
        queue.offer(new int[] {subin, 0});

        if(brother <= subin) System.out.println(subin - brother);
        
        while(!queue.isEmpty() && brother > subin) {
            int[] temp = queue.poll();
            if(temp[0] == brother) {
                System.out.println(temp[1]);
                break;
            }

            if(temp[0] + 1 <= brother && !visited[temp[0] + 1]) {
                visited[temp[0] + 1] = true;
                queue.offer(new int[] {temp[0] + 1, temp[1] + 1});
            }
            if(temp[0] - 1 > 0 && !visited[temp[0] - 1]) {
                visited[temp[0] - 1] = true;
                queue.offer(new int[] {temp[0] - 1, temp[1] + 1});
            }
            if(temp[0] * 2 <= brother + 1 && !visited[temp[0] * 2]) {
                visited[temp[0] * 2] = true;
                queue.offer(new int[] {temp[0] * 2, temp[1] + 1});
            }
        }
    }
}
