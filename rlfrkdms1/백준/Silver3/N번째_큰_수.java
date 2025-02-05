import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(reader.readLine());

        int[] numbers = new int[size*size];
        for(int i = 0; i < size; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < size; j++) {
                numbers[i * size + j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        Arrays.sort(numbers);
        
        writer.write(String.valueOf(numbers[size * size - size]));
        writer.flush();   
        writer.close();
    }
}
