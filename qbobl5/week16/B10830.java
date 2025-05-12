import java.io.*;
import java.util.*;

public class B10830 {
    static int[][] matrix;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        matrix = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
        }

        int[][] result = pow(matrix, B);
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) sb.append(result[i][j]).append(" ");
            sb.append("\n");
        }
        
        System.out.println(sb);
    }

    static int[][] pow(int[][] matrix, long B) {
        if(B == 1L) return matrix;
        int[][] temp = pow(matrix, B / 2);
        if(B % 2 == 0) return multiply(temp, temp);
        else return multiply(multiply(temp, temp), matrix);
    }

    static int[][] multiply(int[][] arr1, int[][] arr2) {
        int[][] result = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<N; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                    result[i][j] %= 1000;
                }
            }
        }

        return result;
    }
}
