package B1.BOJ1157;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 단어 공부
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String string = br.readLine();
        string = string.toUpperCase();

        HashMap<Character, Integer> map = addHashMap(string);

        int max = 0;
        for(Character ch : map.keySet()){
            max = Math.max(max, map.get(ch));
        }
        List<Character> list = new ArrayList<Character>();
        for(Character ch : map.keySet()){
            if(map.get(ch) == max){
                list.add(ch);
            }
        }
        if(list.size() > 1){
            bw.write("?");
            bw.flush();
        } else {
            bw.write(list.get(0) + "");
            bw.flush();
        }

    }

    public static HashMap<Character, Integer> addHashMap(String string){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<string.length(); i++){
            char ch = string.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            } else {
                map.replace(ch, map.get(ch) + 1);
            }
        }
        return map;
    }
}
