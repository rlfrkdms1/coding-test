import java.util.*;
import java.io.*;

public class B16234 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] land = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) land[i][j] = Integer.parseInt(st.nextToken());
        }

        Set<List<int[]>> set = new HashSet<>();
        int count = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        
        while(true) {
            boolean[][] visited = new boolean[N][N];
            Queue<int[]> queue = new LinkedList<>();
            
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(visited[i][j]) continue;
                    queue.offer(new int[] {i, j});
                    List<int[]> list = new ArrayList<>();
                    visited[i][j] = true;
                    
                    while(!queue.isEmpty()) {
                        int[] index = queue.poll();
                        list.add(new int[] {index[0], index[1]});
                        
                        for(int k=0; k<4; k++) {
                            int row = index[0] + dx[k];
                            int col = index[1] + dy[k];
                            if(row < 0 || col < 0 || row >= N || col >= N) continue;
                            if(visited[row][col]) continue;
                            int sub = Math.abs(land[row][col] - land[index[0]][index[1]]);
                            if(sub < L || sub > R) continue;
                            queue.offer(new int[] {row, col});
                            visited[row][col] = true;
                        }
                    }
                    if(list.size() > 1) set.add(list);
                }
            }

            if(set.size() == 0) break;
            for(List<int[]> l:set) {
                int size = l.size();
                int sum = 0;
                for(int[] arr:l) sum += land[arr[0]][arr[1]];
                int result = sum / size;
                for(int[] arr:l) land[arr[0]][arr[1]] = result;
            }
            set.clear();
            count ++;
        }

        System.out.println(count);
    }
}
