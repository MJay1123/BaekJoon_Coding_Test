package Silver.S3.BOJ24511;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] typeArray = new int[N];
        for(int i=0; i<N; i++) {
            int type = Integer.parseInt(st.nextToken());
            typeArray[i] = type;
        }
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            int number = Integer.parseInt(st.nextToken());
            if(typeArray[i] == 0){
                list.add(number);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=list.size()-1; i>=0; i--){
            queue.offer(list.get(i));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int number = Integer.parseInt(st.nextToken());
            queue.offer(number);
            bw.write(queue.poll() + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
