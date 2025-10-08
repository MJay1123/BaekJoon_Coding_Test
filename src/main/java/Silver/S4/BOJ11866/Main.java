package Silver.S4.BOJ11866;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            queue.offer(i);
        }
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            for(int i=0; i<K-1; i++){
                queue.offer(queue.poll());
            }
            list.add(queue.poll());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i=0; i<list.size()-1; i++){
            sb.append(list.get(i) + ", ");
        }
        sb.append(list.get(list.size()-1) + ">");
        bw.write(sb.toString());
        bw.flush();
    }
}
