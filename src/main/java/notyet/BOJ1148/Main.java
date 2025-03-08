package notyet.BOJ1148;

import java.io.*;
import java.util.*;

// 단어 만들기
public class Main {
    static List<String> dictionary = new ArrayList<>();
    static Map<Character, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(char c = 'A'; c <= 'Z'; c++){
            map.put(c, 0);
        }
        while(true){
            if(br.readLine().equals("-")){
                break;
            }
            String word = br.readLine();
            if(word.length() <= 9){
                dictionary.add(word);
            }
        }
        System.out.println(map);

        while(true){
            if(br.readLine().equals("#")){
                break;
            }
            String[] alphabet = br.readLine().split("");
            for(int i=0; i<alphabet.length; i++){
                System.out.println("abc".toCharArray());
            }

        }


    }
}
