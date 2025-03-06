import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        boolean[][] matrix = new boolean[h][w];
        st = new StringTokenizer(br.readLine());
        int all = h * w;
        int block = 0;
        
        for(int i=0; i<w; i++) {
            int count = Integer.parseInt(st.nextToken());
            for(int j=0; j<count; j++) matrix[j][i] = true;
            block += count;
        }

        int count = 0;
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(matrix[i][j]) break;
                count ++;
                matrix[i][j] = true;
            }
            for(int j=w-1; j>=0; j--) {
                if(matrix[i][j]) break;
                count ++;
                matrix[i][j] = true;
            }
        }

        System.out.println(all - block - count);
    }
}
