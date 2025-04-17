import java.io.*;
import java.util.*;

public class B1943 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<3; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] coins = new int[N][2];
            int sum = 0;
            
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                coins[i][0] = Integer.parseInt(st.nextToken());
                coins[i][1] = Integer.parseInt(st.nextToken());
                sum += coins[i][0] * coins[i][1];
            }
            
            Arrays.sort(coins, (a, b) -> a[0] - b[0]);
            if(sum % 2 != 0) {
                sb.append(0).append("\n");
                continue;
            }
            
            int target = sum / 2;
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;
            int max = 0;
            
            for(int i=0; i<N; i++) {
                int coin = coins[i][0];
                max += coin * coins[i][1];
                for(int j=0; j<=target; j++) {
                    int temp = j + coin;
                    if(temp <= max && temp <= target && dp[j]) dp[temp] = true;
                }
            }
            
            if(dp[target]) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        
        System.out.println(sb);
    }
}
