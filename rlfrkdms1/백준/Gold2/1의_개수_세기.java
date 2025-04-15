import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        long A = Long.parseLong(tokenizer.nextToken());
        long B = Long.parseLong(tokenizer.nextToken());

        System.out.println(count(B) - count(A - 1));
    }

    private static long count(long number) {
        if(number < 2) return number;

        int digit = 0;
        long power = 1;

        while(power * 2 <= number) {
            power *= 2;
            digit++;
        }

        return digit * power / 2 + number - power + 1 + count(number - power);
    }
}
