package Gold.G4.BOJ7662;

import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            int K = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int k = 0; k < K; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String operation = st.nextToken();
                if (operation.equals("I")) {
                    int num = Integer.parseInt(st.nextToken());
                    if (!hm.containsKey(num)) {
                        hm.put(num, 0);
                    }
                    hm.put(num, hm.get(num) + 1);
                    minQueue.offer(num);
                    maxQueue.offer(num);
                    count++;
                } else {
                    int a = Integer.parseInt(st.nextToken());
                    if (a == 1) {
                        while(!maxQueue.isEmpty()){
                            int num = maxQueue.poll();
                            if(!hm.containsKey(num) || hm.get(num) == 0){
                                continue;
                            } else {
                                hm.put(num, hm.get(num) - 1);
                                break;
                            }
                        }
                    } else {
                        while(!minQueue.isEmpty()){
                            int num = minQueue.poll();
                            if(!hm.containsKey(num) || hm.get(num) == 0){
                                continue;
                            } else {
                                hm.put(num, hm.get(num) - 1);
                                break;
                            }
                        }
                    }
                    if(count > 0){
                        count--;
                    }
                }
            }
            if (count == 0) {
                bw.write("EMPTY\n");
            } else {
                int max = 0;
                int min = 0;
                while(!maxQueue.isEmpty()){
                    max = maxQueue.poll();
                    if(hm.get(max) == 0){
                        continue;
                    } else {
                        break;
                    }
                }
                while(!minQueue.isEmpty()){
                    min = minQueue.poll();
                    if(hm.get(min) == 0){
                        continue;
                    } else {
                        break;
                    }
                }
                bw.write(max + " " + min + "\n");
            }
        }
        bw.flush();
    }
}
