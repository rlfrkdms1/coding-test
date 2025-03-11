import java.util.*;
import java.io.*;

public class B22251 {
    static int N;
    static int K;
    static int P;
    static int X;
    static int count;
    static boolean[][] numbers = {
        {true, true, true, false, true, true, true},
        {false, false, true, false, false, false, true},
        {false, true, true, true, true, true, false},
        {false, true, true, true, false, true, true},
        {true, false, true, true, false, false, true},
        {true, true, false, true, false, true, true},
        {true, true, false, true, true, true, true},
        {false, true, true, false, false, false, true},
        {true, true, true, true, true, true, true},
        {true, true, true, true, false, true, true}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        recursion(K, P, 0);
        System.out.println(count);
    }

    private static void recursion(int k, int p, int current) {
        if(k == 0) {
            if(current != X && current >= 1 && current <= N) count ++;
            return;
        }

        int number = X / (int)(Math.pow(10, k - 1));
        number %= 10;
        for(int i=0; i<10; i++) {
            int temp = 0;
            for(int j=0; j<7; j++) if(numbers[i][j] != numbers[number][j]) temp++;
            if(temp <= p) recursion(k - 1, p - temp, (int)(Math.pow(10, k - 1) * i) + current);
        }
    }
}
