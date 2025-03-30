import java.util.*;
import java.io.*;

public class B1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] buildings = new int[N];
        for(int i=0; i<N; i++) buildings[i] = Integer.parseInt(st.nextToken());

        int max = 0;
        for(int cur=0; cur<N; cur++) {
            int count = 0;

            double left = Double.MAX_VALUE;
            for(int l=cur-1; l>=0; l--) {
                double temp = (double) (buildings[cur] - buildings[l]) / (cur - l);
                if(temp < left) {
                    count++;
                    left = temp;
                }

            }

            double right = Double.MAX_VALUE;
            for(int r=cur+1; r<N; r++) {
                double temp = (double) (buildings[cur] - buildings[r]) / (r - cur);
                if(temp < right) {
                    count++;
                    right = temp;
                }
            }

            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
