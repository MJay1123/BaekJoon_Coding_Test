package Bronze.B2.BOJ1371;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

// 가장 많은 글자
public class Main {
    static HashMap<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            String temp = br.readLine();
            if(temp == null){
                break;
            }
            st = new StringTokenizer(temp);
            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    if (map.containsKey(c)) {
                        map.replace(c, map.get(c) + 1);
                    } else {
                        map.put(c, 1);
                    }
                }
            }
        }
        int max = 0;
        for(int i : map.values()){
            max = Math.max(max, i);
        }
        List<Character> list = new ArrayList<>();
        for(char ch : map.keySet()){
            if(map.get(ch) == max){
                list.add(ch);
            }
        }
        Collections.sort(list);
        for(char c : list){
            bw.write(c);
        }
        bw.write("\n");
        bw.flush();
    }
}
