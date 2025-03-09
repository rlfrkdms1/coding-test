import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static Set<Integer> set = new TreeSet<>();
    static int[] numbers;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        
        numbers = new int[size]; 
        for(int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(reader.readLine()) - 1;
        }

        visited = new boolean[size];
        
        for(int i = 0; i < size; i++) {
            if(!set.contains(i)) {
                Deque<Integer> path = new ArrayDeque<>();
                path.offer(i);
                visited[i] = true;
                find(path);
                visited[i] = false;
            }
        }

        StringJoiner answer = new StringJoiner(System.lineSeparator());
        answer.add(String.valueOf(set.size()));
        for(int number : set) answer.add(String.valueOf(number + 1));
        System.out.println(answer.toString());
    }

    private static void find(Deque<Integer> path) {
        int first = path.peekFirst();
        int target = numbers[path.peekLast()];
        
        if(first == target) { // 사이클 형성
            while(!path.isEmpty()) set.add(path.poll());
            return;
        }

        if(!set.contains(target) && !visited[target]) {
            visited[target] = true;
            path.offer(target);
            find(path);
            visited[target] = false;
        }
    }
}
