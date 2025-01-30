import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int playerSize = Integer.parseInt(tokenizer.nextToken());
        int limit = Integer.parseInt(tokenizer.nextToken());

        List<Integer> levels = new ArrayList<>();
        Map<Integer, List<Player>> rooms = new HashMap<>();
        for(int i = 0; i < playerSize; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int level = Integer.parseInt(tokenizer.nextToken());
            String nickname = tokenizer.nextToken();
            boolean entrance = false;
            for(int j = 0; j < levels.size(); j++) {
                int standardLevel = levels.get(j);
                if(standardLevel-10 <= level && level <= standardLevel+10 && rooms.get(j).size() < limit) {
                    rooms.get(j).add(new Player(nickname, level));
                    entrance = true;
                    break;
                }
            }
            if(!entrance) {
                List<Player> players = new ArrayList<>();
                players.add(new Player(nickname, level));
                rooms.put(levels.size(), players);
                levels.add(level);
            }
        }
        
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        for(int key : rooms.keySet()) {
            List<Player> players = rooms.get(key);
            players.sort((p1, p2) -> p1.nickname.compareTo(p2.nickname));
            if(players.size() == limit) joiner.add("Started!");
            else joiner.add("Waiting!");
            for(Player player : players) {
                joiner.add(player.toString());
            }
        }
        System.out.println(joiner.toString());
    }

    static class Player {
        String nickname;
        int level;

        public Player(String nickname, int level) {
            this.nickname = nickname;
            this.level = level;
        }

        public String toString() {
            StringJoiner joiner = new StringJoiner(" ");
            joiner.add(String.valueOf(level));
            joiner.add(nickname);
            return joiner.toString();
        }
    }
}
