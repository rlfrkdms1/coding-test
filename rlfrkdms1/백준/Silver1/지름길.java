import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    static Map<Integer, Map<Integer, Integer>> streets = new TreeMap<>();
    static List<Integer> starts;
    static int answer;
    static int goal;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        goal = Integer.parseInt(tokenizer.nextToken());
        answer = goal;

        for(int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int distance = Integer.parseInt(tokenizer.nextToken());
            
            if(end > goal || distance >= end - start) continue;

            Map<Integer, Integer> costs = streets.getOrDefault(start, new HashMap<>());
            costs.put(end, Math.min(costs.getOrDefault(end, Integer.MAX_VALUE), distance));

            if(!streets.containsKey(start)) streets.put(start, costs);
        }

        starts = new ArrayList<>(streets.keySet());
        for(int i = 0; i < starts.size(); i++) {
            int start = starts.get(i);
            Map<Integer, Integer> costs = streets.get(start);
            List<Integer> ends = new ArrayList<>(costs.keySet());
            for(int j = 0; j < ends.size(); j++) {
                int end = ends.get(j);
                dfs(end, start + costs.get(end), i);
            }
        }

        System.out.println(answer);
        
    }

    //temp : 현재 위치, distance : 걸린 거리, index : list key
    static void dfs(int temp, int distance, int index) {

        answer = Math.min(goal - temp + distance, answer);

        for(int i = index + 1; i < starts.size(); i++) {
            int start = starts.get(i);
            if(start < temp) continue;
            Map<Integer, Integer> costs = streets.get(start);
            List<Integer> ends = new ArrayList<>(costs.keySet());
            for(int j = 0; j < ends.size(); j++) {
                int end = ends.get(j);
                dfs(end, distance + (start - temp) + costs.get(end), i);
            }
        }
    }
}
