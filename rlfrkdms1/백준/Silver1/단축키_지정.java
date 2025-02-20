import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static Set<Character> shortcuts = new HashSet<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringJoiner answer = new StringJoiner(System.lineSeparator());
        for(int i = 0; i < n; i++) {
            String option = reader.readLine();
            answer.add(getShortCutOption(option));
        }
        System.out.println(answer.toString());
    }

    private static String getShortCutOption(String option) {
        StringTokenizer tokenizer = new StringTokenizer(option);

        String[] words = new String[tokenizer.countTokens()];

        for(int i = 0; i < words.length; i++) {
            String word = tokenizer.nextToken();
            words[i] = word;
        }

        for(int i = 0; i < words.length; i++) {
            char target = words[i].toLowerCase().charAt(0);
            if(!shortcuts.contains(target)) {
                words[i] = getShortCutForm(words[i], 0);
                shortcuts.add(target);
                StringJoiner answer = new StringJoiner(" ");
                for(int j = 0; j < words.length; j++) {
                    answer.add(words[j]);
                }
                return answer.toString();
            }
        }

        String lowerCase = option.toLowerCase();
        for(int i = 0; i < option.length(); i++) {
            if(lowerCase.charAt(i) != ' ' && !shortcuts.contains(lowerCase.charAt(i))) {
                shortcuts.add(lowerCase.charAt(i));
                return getShortCutForm(option, i);
            }
        }
        
        return option;
    }

    private static String getShortCutForm(String word, int index) {
        StringBuilder shortcutOption = new StringBuilder(word);
        shortcutOption.insert(index + 1, ']');
        shortcutOption.insert(index, '[');
        return shortcutOption.toString();
    }
}
