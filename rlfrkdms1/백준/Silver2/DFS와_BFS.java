import java.util.*;
import java.lang.*;
import java.io.*;



class Main {

    static Map<Integer, Vertex> vertexMap = new HashMap<>();
    static boolean[] visited;
    static List<Integer> dfsAnswer = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int v = Integer.parseInt(tokenizer.nextToken());
        visited = new boolean[n+1];

        for(int i = 0; i < n; i++) {
            vertexMap.put(i + 1, new Vertex(i + 1));
        }

        for(int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int vertex1 = Integer.parseInt(tokenizer.nextToken());
            int vertex2 = Integer.parseInt(tokenizer.nextToken());

            vertexMap.get(vertex1).connect(vertex2);
            vertexMap.get(vertex2).connect(vertex1);
        }

        for(int key : vertexMap.keySet()) {
            vertexMap.get(key).sort();
        }
        
        dfs(v);
        StringJoiner answer = new StringJoiner(" ");
        for(int i = 0; i < dfsAnswer.size(); i++) {
            answer.add(String.valueOf(dfsAnswer.get(i)));
        }
        System.out.println(answer.toString());
        Arrays.fill(visited, false);
        System.out.println(bfs(v));
        
    }

    private static void dfs(int vertex) {
        
        visited[vertex] = true;
        dfsAnswer.add(vertex);

        List<Integer> connectedVertices = vertexMap.get(vertex).connectedVertices;
        for(int i = 0; i < connectedVertices.size(); i++) {
            int connectedVertex = connectedVertices.get(i);
            if(!visited[connectedVertex]) dfs(connectedVertex);
        }
        
    }

    private static String bfs(int start) {
        
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(vertexMap.get(start));
        visited[start] = true;

        StringJoiner answer = new StringJoiner(" ");

        while(!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            answer.add(String.valueOf(vertex.number));

            List<Integer> connectedVertices = vertex.connectedVertices;
            for(int i = 0; i < connectedVertices.size(); i++) {
                int connectedVertex = connectedVertices.get(i);
                if(!visited[connectedVertex]) {
                    queue.offer(vertexMap.get(connectedVertex));
                    visited[connectedVertex] = true;
                }
            }
        }

        return answer.toString();
    }

    static class Vertex {
        List<Integer> connectedVertices = new ArrayList<>();
        int number;

        public Vertex(int number) {
            this.number = number;
        }

        public void connect(int vertex) {
            connectedVertices.add(vertex);
        }

        public void sort() {
            Collections.sort(connectedVertices);
        }
    }
}
