package B2.BOJ1159;

import java.io.*;
import java.util.*;

// 농구 경기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());        // N : 선수들 수

        String[] players = new String[N];
        for(int i=0; i<N; i++){
            players[i] = br.readLine();
        }

        HashSet<Character> set = new HashSet<Character>();
        for(int i=0; i<N; i++){
            set.add(players[i].charAt(0));
        }
        List<Character> list = new ArrayList<>();
        for(char ch : set){
            if(count(ch, players)){
                list.add(ch);
            }
        }
        if(list.size() > 0) {
            StringBuilder sb = new StringBuilder();

            Collections.sort(list);
            for (char ch : list) {
                sb.append(ch);
            }
            bw.write(sb.toString());
            bw.flush();
        } else {
            bw.write("PREDAJA");
            bw.flush();
        }
    }

    public static boolean count(char ch, String[] players){
        int count = 0;
        for(int i=0; i<players.length; i++){
            if(players[i].charAt(0) == ch){
                count++;
            }
            if(count >= 5){
                return true;
            }
        }
        return false;
    }
}
