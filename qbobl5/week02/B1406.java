package qbobl5.week02;

import java.util.*;
import java.io.*;

public class B1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstWord = br.readLine();
        int commandCount = Integer.parseInt(br.readLine());

        List<Character> wordList = new LinkedList<>();
        for(char c:firstWord.toCharArray()) wordList.add(c);

        ListIterator<Character> cursor = wordList.listIterator(firstWord.length());
        for(int i=0; i<commandCount; i++) {
            String commandLine = br.readLine();
            char command = commandLine.charAt(0);
            if(command == 'L') {
                if(cursor.hasPrevious()) cursor.previous();
            } else if(command == 'D') {
                if(cursor.hasNext()) cursor.next();
            } else if(command == 'B') {
                if(cursor.hasPrevious()) {
                    cursor.previous();
                    cursor.remove();
                }
            } else cursor.add(commandLine.charAt(2));
        }

        StringBuilder sb = new StringBuilder();
        for(char c:wordList) sb.append(c);
        System.out.println(sb);
    }
}