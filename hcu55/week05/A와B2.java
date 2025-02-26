import java.io.*;
import java.util.*;

// A와 B 2(dfs), 골드 V
public class A와B2 {
    static String S, T;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        dfs(T);
        System.out.println(result);
    }

    public static void dfs(String current) {
        if (current.equals(S)) {
            result = 1;
            return;
        }

        if (current.length() < S.length()) {
            return;
        }

        if (current.charAt(current.length() - 1) == 'A') {
            dfs(current.substring(0, current.length() - 1));
        }

        if (current.charAt(0) == 'B') {
            String removedB = current.substring(1);
            StringBuilder reversed = new StringBuilder(removedB);
            reversed.reverse();
            dfs(reversed.toString());
        }
    }
}
