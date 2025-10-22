package Gold.G2.BOJ1202;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static long answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 보석 개수
        int K = Integer.parseInt(st.nextToken());   // 가방 개수
        PriorityQueue<Gem> gems = new PriorityQueue<>(new Comparator<Gem>(){
            @Override
            public int compare(Gem o1, Gem o2) {
                return o1.weight - o2.weight;
            }
        });
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            gems.offer(new Gem(weight, price));
        }
        PriorityQueue<Integer> bags = new PriorityQueue<>();
        for(int k=0; k<K; k++){
            bags.offer(Integer.parseInt(br.readLine()));
        }
        PriorityQueue<Gem> pq = new PriorityQueue<>(new Comparator<Gem>() {
            @Override
            public int compare(Gem o1, Gem o2) {
                if(o1.price != o2.price){
                    return o2.price - o1.price;
                } else {
                    return o1.weight - o2.weight;
                }
            }
        });
        if(N < K){
            while(gems.size() != bags.size()){
                bags.poll();
            }
        }
        while(!bags.isEmpty()){
            int capacity = bags.poll();
            while(!gems.isEmpty()){
                Gem gem = gems.peek();
                if(gem.weight <= capacity){
                    pq.offer(gems.poll());
                } else {
                    break;
                }
            }
            if(!pq.isEmpty()) {
                answer += pq.poll().price;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }

    static class Gem {
        int weight;
        int price;
        public Gem(int weight, int price){
            this.weight = weight;
            this.price = price;
        }
    }
}
