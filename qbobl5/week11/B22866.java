import java.io.*;
import java.util.*;

public class B22866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] height = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) height[i] = Integer.parseInt(st.nextToken());

        int[] left = new int[N + 1];
        int[] right = new int[N + 1];
        int[] near = new int[N + 1];
        
        for(int i=2; i<=N; i++){
            for(int j=i-1; j>0; j--){
                if(height[j] > height[i]){
                    left[i] = left[j] + 1;
                    near[i] = j;
                    break;
                }
            }
        }

        for(int i=N-1; i>0; i--){
            for(int j=i+1; j<=N; j++){
                if(height[j] > height[i]){
                    if(near[i] == 0 || (j-i) < (i-near[i])) near[i] = j;
                    right[i] = right[j] + 1;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            int count = left[i] + right[i];
            if(count == 0) sb.append("0\n");
            else sb.append(count).append(" ").append(near[i]).append("\n");
        }
        System.out.println(sb);
    }
}
