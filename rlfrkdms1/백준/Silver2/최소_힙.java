import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());

        Queue<Integer> heap = new PriorityQueue<>();
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        for(int i = 0; i < size; i++) {
            int input = Integer.parseInt(reader.readLine());
            if(input == 0) {
                Integer min = heap.poll();
                if(min == null) joiner.add("0");
                else joiner.add(String.valueOf(min));
            } else {
                heap.add(input);
            }
        }
        System.out.println(joiner.toString());
    }
}
