package notyet.BOJ1148;

import java.io.*;
import java.util.*;

// 단어 만들기
public class Main {
    static List<String> words = new ArrayList<>();
    static List<int[]> dictionary = new ArrayList<>();
    static List<int[]> puzzles = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String word = br.readLine();
            if(word.equals("-")){
                break;
            }
            int[] array = new int[26];
            words.add(word);
            for(int i=0; i<word.length(); i++){
                int num = word.charAt(i) - 'A';
                array[num]++;
            }
            dictionary.add(array);
        }
        while(true){
            String puzzle = br.readLine();
            if(puzzle.equals("#")){
                break;
            }
            int[] array = new int[26];
            for(int i=0; i<puzzle.length(); i++){
                int num = puzzle.charAt(i) - 'A';
                array[num]++;
            }
            puzzles.add(array);
        }
        System.out.println("dictionary = " + dictionary);
        for(int i=0; i<dictionary.size(); i++){
            System.out.println(Arrays.toString(dictionary.get(i)));
        }
        System.out.println("puzzles = " + puzzles);
        for(int i=0; i<puzzles.size(); i++){
            System.out.println(Arrays.toString(puzzles.get(i)));
        }
        for(int i=0; i<puzzles.size(); i++){
            int[] puzzle = puzzles.get(i);
            for(int j=0; j<dictionary.size(); j++){
                int[] word = dictionary.get(j);
                for(int k=0; k<26; k++){

                }
            }
        }
        for(String word : words){
            for(int i=0; i<word.length(); i++){

            }
        }
    }
}
