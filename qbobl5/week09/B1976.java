import java.util.*;
import java.io.*;

public class B1976 {
    static int[] city;

    static int find(int c) {
        if(city[c] == c) return c;
        return city[c] = find(city[c]);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        city = new int[N + 1];
        for(int i=1; i<=N; i++) city[i] = i;

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                if(st.nextToken().equals("1")) {
                    int c1 = find(i);
                    int c2 = find(j);
                    if (c1 != c2) city[c2] = c1;
                }
            }
        }

        int[] travel = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) travel[i] = Integer.parseInt(st.nextToken());

        boolean flag = true;
        int target = find(travel[0]);
        for(int i=1; i<M; i++) {
            if(find(travel[i]) != target) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }
}
