import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    static int[][] convert = new int[10][10];
    static int[] temp;
    static int p;
    static int answer = 0;
    static int[] range;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        String n = tokenizer.nextToken();
        int m = Integer.parseInt(tokenizer.nextToken());
        range = new int[n.length()];
        for(int i = 0; i < n.length(); i++) range[i] = n.charAt(i) - '0';
        p = Integer.parseInt(tokenizer.nextToken());
        String x = tokenizer.nextToken();
        temp = new int[n.length()];
        for(int i = 0; i < x.length(); i++) temp[i + n.length() - x.length()] = x.charAt(i) - '0';
        
        boolean[][] numbers = {
            {true, true, true, false, true, true, true},
            {false, false, true, false, false, true, false},
            {true, false, true, true, true, false, true},
            {true, false, true, true, false, true, true},
            {false, true, true, true, false, true, false},
            {true, true, false, true, false, true, true},
            {true, true, false, true, true, true, true},
            {true, false, true, false, false, true, false},
            {true, true, true, true, true, true, true},
            {true, true, true, true, false, true, true}
        };

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                int count = 0;
                for(int k = 0; k < 7; k++) {
                    if(numbers[i][k] ^ numbers[j][k]) count++;
                }
                convert[i][j] = count;
            }
        }

        dfs(new int[n.length()], 0, 0, false);
        System.out.println(answer);
    }

    private static void dfs(int[] number, int count, int digit, boolean lower) {

        if(count > p) return;
        if(digit == range.length) {
            boolean zero = true;
            for(int i = 0; i < number.length; i++) {
                if(number[i] != 0) {
                    zero = false;
                }
            }
            if(!zero && count > 0) answer++;
            return;
        }

        int limit = lower ? 9 : range[digit];
        for(int i = 0; i <= limit; i++) {
            number[digit] = i;
            dfs(number, count + convert[temp[digit]][i], digit + 1, lower ? true : i < range[digit]);
        }

    }
}
