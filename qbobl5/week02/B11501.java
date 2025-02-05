package qbobl5.week02;

import java.util.*;
import java.io.*;

public class B11501 {
    static long getBest(int[] stocks) {
        int max = 0;
        long profit = 0;

        for(int i=stocks.length - 1; i>=0; i--) {
            if(stocks[i] > max) max = stocks[i];
            else profit += (max - stocks[i]);
        }

        return profit;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCount = Integer.parseInt(br.readLine());
        for(int i=0; i<testCount; i++) {
            int dayCount = Integer.parseInt(br.readLine());
            int[] stocks = new int[dayCount];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<dayCount; j++) stocks[j] = Integer.parseInt(st.nextToken());
            sb.append(getBest(stocks)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}