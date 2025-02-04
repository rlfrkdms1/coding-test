import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(reader.readLine());

        int[][] sticks = new int[size][2];
        int max = 0;
        for(int i = 0; i < size; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            sticks[i][0] = Integer.parseInt(tokenizer.nextToken());
            sticks[i][1] = Integer.parseInt(tokenizer.nextToken());
            if(sticks[i][1] > max) max = sticks[i][1];
        }

        Arrays.sort(sticks, (s1, s2) -> s1[0] - s2[0]);

        int area = 0;

        //가운데 면적 계산
        int maxIndex = -1;
        int maxLastIndex = -1;
        for(int i = 0; i < size; i++) {
            if(sticks[i][1] == max) {
                maxLastIndex = i;
                if(maxIndex == -1) maxIndex = i;
            }
        }

        int centerLength = maxIndex == maxLastIndex ? 1 : (sticks[maxLastIndex][0] - sticks[maxIndex][0] + 1);
        area += max * centerLength;
        
        //왼쪽 면적 계산
        for(int i = 0; i < maxIndex; i++) {
            int length = sticks[i][1];
            for(int j = i + 1; j <= maxIndex; j++) {
                if(sticks[j][1] > length) {
                    area += length * (sticks[j][0] - sticks[i][0]);
                    i = j - 1;
                    break;
                }
            }
        }

        //오른쪽 면적 계산
        for(int i = size - 1; i > maxLastIndex; i--) {
            int length = sticks[i][1];
            for(int j = i - 1; j >= maxIndex; j--) {
                if(sticks[j][1] > length) {
                    area += length * (sticks[i][0] - sticks[j][0]);
                    i = j + 1;
                    break;
                }
            }
        }

        writer.write(String.valueOf(area));
        writer.flush();   
        writer.close();
    }
}
