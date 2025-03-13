import java.io.*;
import java.util.*;

public class B7490 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    
    static void dfs(int index, int number, int sum, int operator, String result) {
        if(index == N) {
            sum += number * operator;
            if(sum == 0) sb.append(result).append("\n");
            return;
        }

        dfs(index + 1, (number*10) + (index+1), sum, operator, result + " " + (index+1));
        dfs(index + 1, index + 1, sum + (number*operator), 1, result + "+" + (index+1));
        dfs(index + 1, index + 1, sum + (number*operator), -1, result + "-" + (index+1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            N = Integer.parseInt(br.readLine());
            dfs(1, 1, 0, 1, "1");
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}
