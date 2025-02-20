package qbobl5.week04;

import java.io.*;
import java.util.*;

public class B1283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<Character> keys = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            String[] words = br.readLine().split(" ");
            int size = words.length;
            boolean check = false;

            for(int j=0; j<size; j++) {
                char c = Character.toLowerCase(words[j].charAt(0));
                if(!keys.contains(c)) {
                    keys.add(c);
                    words[j] = "[" + words[j].charAt(0) + "]" + words[j].substring(1);
                    check = true;
                    break;
                }
            }

            if(!check) {
                outer:
                for(int j=0; j<size; j++) {
                    for(int k=0; k<words[j].length(); k++) {
                        char c = Character.toLowerCase(words[j].charAt(k));
                        if(!keys.contains(c)) {
                            keys.add(c);
                            words[j] = words[j].substring(0, k) + "[" + words[j].charAt(k) + "]" + words[j].substring(k + 1);
                            check = true;
                            break outer;
                        }
                    }
                }
            }

            sb.append(String.join(" ", words)).append("\n");
        }

        System.out.println(sb);
    }
}
