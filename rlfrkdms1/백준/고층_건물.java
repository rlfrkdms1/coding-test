import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] buildings = new int[size];
        for(int i = 0; i < size; i++) {
            buildings[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int answer = 0;
        for(int i = 0; i < size; i++) {
            
            int count = 0;
            double temp = 0;
            
            for(int j = i - 1; j >= 0; j--) {
                double slope = (double) (buildings[j] - buildings[i]) / (j - i);
                if(j == i - 1 || slope < temp) {
                    count++;
                    temp = slope;
                }
            }
            for(int j = i + 1; j < size; j++) {
                double slope = (double) (buildings[j] - buildings[i]) / (j - i);
                if(j == i + 1 || slope > temp) {
                    count++;
                    temp = slope;
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}
