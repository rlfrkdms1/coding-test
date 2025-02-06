package qbobl5.week02;

import java.util.*;
import java.io.*;

public class B2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] cols = new int[N][2];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cols[i][0] = Integer.parseInt(st.nextToken());
            cols[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cols, (col1, col2) -> col1[0] - col2[0]);

        int maxIndex = 0;
        for(int i=1; i<N; i++) if(cols[i][1] > cols[maxIndex][1]) maxIndex = i;

        int area = cols[maxIndex][1];
        int left = 0;
        int right = 0;
        while(right <= maxIndex) {
            if(cols[right][1] >= cols[left][1]) {
                area += cols[left][1] * (cols[right][0] - cols[left][0]);
                left = right;
            }
            right ++;
        }

        left = N - 1;
        right = N - 1;
        while(left >= maxIndex) {
            if(cols[left][1] >= cols[right][1]) {
                area += cols[right][1] * (cols[right][0] - cols[left][0]);
                right = left;
            }
            left --;
        }

        System.out.println(area);
    }
}