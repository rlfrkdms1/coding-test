import java.io.*;
import java.util.*;

public class B2668 {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list;
    
    static void dfs(int index, int start) {
        if(!visited[arr[index]]){
            visited[arr[index]] = true;
            dfs(arr[index], start);
            visited[arr[index]] = false;
        }
        if(arr[index] == start) list.add(start);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList<>();

        for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        int size = list.size();
        sb.append(size).append("\n");
        for(int i=0; i<size; i++) sb.append(list.get(i)).append("\n");
        System.out.println(sb);
    }
}
