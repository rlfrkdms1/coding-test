import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());

        StringJoiner answer = new StringJoiner(System.lineSeparator());

        for(int i = 0; i < size; i++) {
            String text = reader.readLine();
            int count = Integer.parseInt(reader.readLine());
            answer.add(getAnswer(text, count));
        }

        System.out.println(answer.toString());
    }

    static String getAnswer(String text, int count) {
        Map<Character, List<Integer>> chars = new HashMap<>();

        for(int i = 0; i < text.length(); i++) {
            char target = text.charAt(i);

            List<Integer> indexes = chars.getOrDefault(target, new ArrayList<>());
            indexes.add(i);

            if(!chars.containsKey(target)) chars.put(target, indexes);
        }

        List<Character> keys = new ArrayList<>(chars.keySet());
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(char key : keys) {
            List<Integer> indexes = chars.get(key);
            Collections.sort(indexes);

            if(indexes.size() >= count) {
                for(int i = 0; i < indexes.size() - count + 1; i++) {
                    int distance = indexes.get(i + count - 1) - indexes.get(i) + 1;
                    min = Math.min(min, distance);
                    max = Math.max(max, distance);
                }
            }
        }

        if(max == 0) return "-1";
        StringBuilder answer = new StringBuilder();
        return answer.append(min).append(" ").append(max).toString();
    }
}
