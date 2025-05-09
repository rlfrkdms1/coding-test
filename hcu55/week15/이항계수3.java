package hcu55.week15;

import java.io.*;
import java.util.*;

// 이항 계수 3(math), 골드 I
public class 이항계수3 {
    static final int MOD = 1_000_000_007;
    static long[] fact;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        long numerator = fact[n];
        long denominator = (fact[k] * fact[n - k]) % MOD;

        long inverse = pow(denominator, MOD - 2);
        System.out.println(numerator * inverse % MOD);
    }

    public static long pow(long a, long b) {
        long result = 1;
        while (b > 0) {
            if (b % 2 == 1) result = (result * a) % MOD;
            a = (a * a) % MOD;
            b = b / 2;
        }
        return result;
    }
}
