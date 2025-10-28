package notyet.BOJ1339;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] count = new int[26][8];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                char ch = str.charAt(j);
                int index = ch - 'A';
                count[index][8-str.length()+j]++;
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for(int i=0; i<8; i++){
                    if(o1[i] != o2[i]){
                        return o2[i] - o1[i];
                    }
                }
                return 0;
            }
        });
        for(int i=0; i<26; i++) {
            pq.offer(count[i]);
        }
        long answer = 0;
        for(int num=9; num>=0; num--){
            int[] arr = pq.poll();
            for(int i=0; i<8; i++){
                answer += (long)Math.pow(10, 7-i) * arr[i] * num;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
