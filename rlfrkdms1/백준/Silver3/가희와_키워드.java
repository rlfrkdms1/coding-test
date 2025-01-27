import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int keywordSize = Integer.parseInt(tokenizer.nextToken());
        int textSize = Integer.parseInt(tokenizer.nextToken());

        Set<String> keywords = new HashSet<>();
        for(int i = 0; i < keywordSize; i++) {
            keywords.add(reader.readLine());
        }
    
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        for(int i = 0; i < textSize; i++) {
            StringTokenizer texts = new StringTokenizer(reader.readLine(), ",");
            while(texts.hasMoreTokens()) {
                String text = texts.nextToken();
                if(keywords.contains(text)) {
                    keywords.remove(text);
                }
            }
            joiner.add(String.valueOf(keywords.size()));
        }

        System.out.println(joiner.toString());
    }
}
