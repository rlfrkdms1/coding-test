import java.util.*;
import java.io.*;

public class B9527 {
    static long countOne(long number) {
        int bitCount = Long.SIZE - Long.numberOfLeadingZeros(number);
        long count = 0;
        for(int i=0; i<bitCount; i++) {
            long size = 1L << (i + 1);
            count += (number + 1) / size * (1L << i);
            count += Math.max(0, (number + 1) % size - (1L << i));
        }
        return count;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        System.out.println(countOne(B) - countOne(A - 1));
    }
}
