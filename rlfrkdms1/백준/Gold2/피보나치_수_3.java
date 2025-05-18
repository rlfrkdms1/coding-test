import java.io.*;

public class Main {
    private static final int MOD = 1_000_000;
    private static final int PISANO_PERIOD = 1_500_000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(reader.readLine());

        int index = (int)(N % PISANO_PERIOD);

        int[] fibo = new int[index + 1];
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= index; i++) fibo[i] = (fibo[i - 1] + fibo[i - 2]) % MOD;
        System.out.println(fibo[index]);
    }
}
