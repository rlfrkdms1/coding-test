import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    static Map<Integer, Set<Integer>> connections = new HashMap<>();
    static boolean[] visited;
    static boolean canGo = true;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        visited = new boolean[N + 1];
        
        for(int i = 1; i <= N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            Set<Integer> cities = new HashSet<>();
            for(int j = 1; j <= N; j++) {
                if(tokenizer.nextToken().equals("1")) cities.add(j);
            }
            connections.put(i, cities);
        }

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int departure = 0;
        int destination = 0;

        for(int i = 0; i < M; i++) {
            if(i == 0) {
                departure = Integer.parseInt(tokenizer.nextToken());
                continue;
            }

            destination = Integer.parseInt(tokenizer.nextToken());
            
            if(!connections.get(departure).contains(destination)) {
                visited[departure] = true;
                canGo = false;
                find(departure, destination, departure);
                if(!canGo) break;
                Arrays.fill(visited, false);
            }
            
            departure = destination;
        }

        System.out.println(canGo ? "YES" : "NO");
    }

    static void find(int departure, int destination, int temp) {
        if(temp == destination) {
            canGo = true;
            return;
        }

        for(int city : connections.get(temp)) {
            if(!visited[city]) {
                visited[city] = true;
                find(departure, destination, city);
            }
        }
    }
}
