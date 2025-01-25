package qbobl5.week01;
import java.util.*;
import java.io.*;

public class B19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] titleList = new String[N];
        int[] powerList = new int[N];
        int size = N - 1;

        for(int i=size; i>=0; i--) {
            st = new StringTokenizer(br.readLine());
            titleList[i] = st.nextToken();
            powerList[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            int left = 0;
            int right = size;
            int power = Integer.parseInt(br.readLine());

            while(left <= right) {
                int mid = (left + right) / 2;
                if(mid == size || (power <= powerList[mid] && power > powerList[mid+1])) {
                    sb.append(titleList[mid]).append("\n");
                    break;
                }
                if(power > powerList[mid]) right = mid - 1;
                else left = mid + 1;
            }
        }

        bw.append(sb.toString());
        bw.close();
    }
}