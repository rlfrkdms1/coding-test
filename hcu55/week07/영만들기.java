import java.io.*;
import java.util.*;

// 0 만들기(dfs), 골드 V
public class Main {
    static int N;
    static List<String> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            N = Integer.parseInt(br.readLine());
            answer = new ArrayList<>();
            dfs(1, "1");
            
            Collections.sort(answer);
            
            for (String ans : answer) {
                System.out.println(ans);
            }
            System.out.println();
        }
    }

    public static void dfs(int current, String str) {
        if (current == N) {
            if (calculate(str.replace(" ", "")) == 0) {
                answer.add(str);
            }
            return;
        }

        dfs(current + 1, str + " " + (current + 1));
        dfs(current + 1, str + "+" + (current + 1));
        dfs(current + 1, str + "-" + (current + 1));
    }

    public static int calculate(String str) {
        int sum = 0;
        int num = 0;
        char sign = '+';

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (isNumber(c)) {
                num = num * 10 + (c - '0');
            }

            if (!isNumber(c) || i == str.length() - 1) {
                if (sign == '+') {
                    sum += num;
                } else if (sign == '-') {
                    sum -= num;
                }

                sign = c;
                num = 0;
            }
        }

        return sum;
    }

    public static boolean isNumber(char c) {
    		if ('1' <= c && c <= '9') return true;
    		return false;
	  }
}
