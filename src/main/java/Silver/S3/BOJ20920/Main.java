package Silver.S3.BOJ20920;

import java.io.*;
import java.util.*;

public class Main {
    static class Word implements Comparable<Word> {
        String word;
        int count;

        public Word(String word, int count){
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(Word o) {
            if(this.count != o.count){
                return o.count - this.count;
            } else if(this.word.length() != o.word.length()){
                return o.word.length() - this.word.length();
            } else {
                return this.word.compareTo(o.word);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0; i<N; i++){
            String word = br.readLine();
            if(word.length() >= M){
                hm.put(word, hm.getOrDefault(word, 0)+1);
            }
        }
        PriorityQueue<Word> pq = new PriorityQueue<>();
        for(String str : hm.keySet()){
            int count = hm.get(str);
            Word word = new Word(str, count);
            pq.offer(word);
        }
        while(!pq.isEmpty()){
            Word word = pq.poll();
            bw.write(word.word + "\n");
        }
        bw.flush();
    }
}
