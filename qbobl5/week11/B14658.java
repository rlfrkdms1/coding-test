import java.io.*;
import java.util.*;

public class B14658 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] stars = new int[K][2];
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Integer.parseInt(st.nextToken());
            stars[i][1] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for(int i=0; i<K; i++) {
            for(int j=0; j<K; j++) {
                int[] min = {Math.min(stars[i][0], stars[j][0]), Math.min(stars[i][1], stars[j][1])};
                int[] max = {min[0] + L, min[1] + L};
                int temp = 0;
                for(int k=0; k<K; k++) if(stars[k][0] >= min[0] && stars[k][1] >= min[1] && stars[k][0] <= max[0] && stars[k][1] <= max[1]) temp++;
                count = Math.max(count, temp);
            }
        }
        System.out.println(K - count);
	}
}
