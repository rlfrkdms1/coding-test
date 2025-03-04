import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int h = Integer.parseInt(tokenizer.nextToken());
        int w = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        int[] blocks = new int[w];

        int max = 0;
        List<Integer> maxIndex = new ArrayList<>();
        for(int i = 0; i < w; i++) {
            blocks[i] = Integer.parseInt(tokenizer.nextToken());
            if(blocks[i] > max) {
                max = blocks[i];
                maxIndex.clear();
                maxIndex.add(i);
            }
            if(blocks[i] == max) maxIndex.add(i);
        }
        int answer = 0;

        //왼쪽
        int left = -1;
        int rains = 0;
        for(int i = 0; i <= maxIndex.get(0); i++) {
            int block = blocks[i];
            if(left == -1) {
                if(block != 0) left = block;
            } else {
                if(block >= left) {
                    left = block;
                    answer += rains;
                    rains = 0;
                } else rains += left - block;
            }
        }

        //가운데
        for(int i = 0; i < maxIndex.size() - 1; i++) {
            for(int j = maxIndex.get(i) + 1; j < maxIndex.get(i+1); j++) {
                answer += max - blocks[j];
            }
        }

        //오른쪽
        left = -1;
        rains = 0;
        for(int i = w - 1; i >= maxIndex.get(maxIndex.size() - 1); i--) {
            int block = blocks[i];
            if(left == -1) {
                if(block != 0) left = block;
            } else {
                if(block >= left) {
                    left = block;
                    answer += rains;
                    rains = 0;
                } else rains += left - block;
            }
        }

        System.out.println(answer);
    }
}
