import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCases = Integer.parseInt(reader.readLine());

        StringJoiner joiner = new StringJoiner(System.lineSeparator());

        for(int i = 0; i < testCases; i++) {
            int size = Integer.parseInt(reader.readLine());
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            long[] stocks = new long[size];
            for(int j = size - 1; j >= 0; j--) {
                stocks[j] = Long.parseLong(tokenizer.nextToken());
            }

            long profit = 0;
            long max = stocks[0];
            for(int j = 1; j < size; j++) {
                if(max >= stocks[j]) profit += max - stocks[j];
                else max = stocks[j];
            }
            joiner.add(String.valueOf(profit));
        }

        writer.write(joiner.toString());
        writer.flush();   
        writer.close();
    }
}
