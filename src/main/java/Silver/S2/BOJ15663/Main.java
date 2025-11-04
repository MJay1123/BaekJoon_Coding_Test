package Silver.S2.BOJ15663;

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> hm = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : hm.keySet()){
            pq.offer(i);
        }
        int[][] numbers = new int[2][hm.keySet().size()];
        for(int i=0; i<numbers[0].length; i++){
            numbers[0][i] = pq.poll();
            numbers[1][i] = hm.get(numbers[0][i]);
        }
        choose(numbers, 0, new ArrayList<Integer>(), M);
        bw.write(sb.toString());
        bw.flush();
    }
    public static void choose(int[][] numbers, int index, List<Integer> list, int M){
        if(list.size() == M){
            for(int i=0; i<list.size(); i++){
                sb.append(list.get(i) + " ");
            }
            sb.append("\n");
            return;
        }
        if(index == numbers[0].length){
            return;
        }
        for(int i=0; i<numbers[0].length; i++){
            if(numbers[1][index] > 0) {
                numbers[1][index]--;
                list.add(numbers[0][index]);
                choose(numbers, index, list, M);
                numbers[1][index]++;
                list.remove(list.size() - 1);
            }
            choose(numbers, index + 1, list, M);
        }
    }
}
