package hcu55.week16;

import java.io.*;
import java.util.*;

// 행렬 제곱(DAC), 골드 IV
public class 행렬제곱 {
    static int N;
    static long B;
    static int[][] base;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        base = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                base[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = matrixPower(base, B);

        for (int[] row : result) {
            for (int val : row) {
                sb.append(val % 1000).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static int[][] matrixMultiply(int[][] A, int[][] B) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += A[i][k] * B[k][j];
                }
                result[i][j] = sum % 1000;
            }
        }

        return result;
    }

    public static int[][] matrixPower(int[][] matrix, long b) {
        if (b == 1) return matrix;

        int[][] half = matrixPower(matrix, b / 2);
        int[][] result = matrixMultiply(half, half);

        if (b % 2 == 1) {
            result = matrixMultiply(result, base);
        }

        return result;
    }
}
