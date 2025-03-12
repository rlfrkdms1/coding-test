import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static Set<String> expressions = new TreeSet<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        StringJoiner answer = new StringJoiner(System.lineSeparator());
        
        for(int i = 0; i < size; i++) {
            int N = Integer.parseInt(reader.readLine());
            dfs(new String[2 * N - 1], 0);
            for(String expression : expressions) answer.add(expression);
            answer.add("");
            expressions.clear();
        }

        System.out.println(answer.toString());
    }

    private static void dfs(String[] expression, int depth) {
        if(depth == expression.length) {
            if(isZero(expression)) expressions.add(String.join("", expression)); 
            return;
        }
        
        if(depth % 2 == 0) { // 숫자
            expression[depth] = String.valueOf(depth/2 + 1);
            dfs(expression, depth + 1);
        } else {
            expression[depth] = "+";
            dfs(expression, depth + 1);
            expression[depth] = "-";
            dfs(expression, depth + 1);
            expression[depth] = " ";
            dfs(expression, depth + 1);
        }
    }

    private static boolean isZero(String[] expression) {
        String number = "";
        int i = 0;
        while(i < expression.length && !expression[i].equals("+") && !expression[i].equals("-")) {
            if(!expression[i].equals(" ")) number += expression[i];
            i++;
        }
        int sum = Integer.parseInt(number);
        number = "";
        String operation = "";
        while(i < expression.length) {
            if(expression[i].equals("+") || expression[i].equals("-")) operation = expression[i];
            else if(!expression[i].equals(" ")) number += expression[i];
            if(i == expression.length - 1 || expression[i+1].equals("+") || expression[i+1].equals("-")) {
                if(operation.equals("+")) sum += Integer.parseInt(number);
                if(operation.equals("-")) sum -= Integer.parseInt(number);
                number = "";
            }
            i++;
        }
        return sum == 0;
    }
}
