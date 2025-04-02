import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());

        int[] numbers = new int[size];
        for(int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }

        int max = 0;
        int[] ordered = new int[size];
        for (int i = 0; i < size; i++) {
            ordered[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) {
                    ordered[i] = Math.max(ordered[i], ordered[j] + 1);
                }
            }
            max = Math.max(max, ordered[i]);
        }

        System.out.println(size - max);        
    }
}
