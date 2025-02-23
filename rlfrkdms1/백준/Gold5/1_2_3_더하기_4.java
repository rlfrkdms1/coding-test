import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());

        int[] sums = new int[10001];
        sums[1] = 1;
        sums[2] = 2;
        sums[3] = 3;

        for(int i = 4; i < 10001; i++) {
            sums[i] = sums[i - 3] + (int) Math.floor(i/2) + 1;
        }
        
        for(int i = 0; i < size; i++) {            
            System.out.println(sums[Integer.parseInt(reader.readLine())]);
        }
    }
}
