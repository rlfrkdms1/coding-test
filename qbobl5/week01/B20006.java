package qbobl5.week01;

import java.io.*;
import java.util.*;

public class B20006 {
    public static class Player implements Comparable<Player> {
        int level;
        String name;
        boolean joined;

        public Player (int level, String name) {
            this.level = level;
            this.name = name;
        }

        public int compareTo(Player p) {
            return name.compareTo(p.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Player[] players = new Player[p];

        for(int i=0; i<p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            players[i] = new Player(level, name);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<p; i++) {
            List<Player> room = new ArrayList<>();
            if(!players[i].joined) {
                for(int j=0; j<p; j++) {
                    if(room.size() == m) break;
                    int level = players[j].level;
                    String name = players[j].name;
                    if(!players[j].joined && players[i].level - 10 <= level && players[i].level + 10 >= level) {
                        players[j].joined = true;
                        room.add(players[j]);
                    }
                }
                Collections.sort(room);
                if(room.size() == m) sb.append("Started!\n");
                else sb.append("Waiting!\n");
                for(Player player : room) sb.append(player.level).append(" ").append(player.name).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
