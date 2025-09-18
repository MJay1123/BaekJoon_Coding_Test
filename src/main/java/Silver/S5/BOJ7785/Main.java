package Silver.S5.BOJ7785;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> employee = new HashSet<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String activity = st.nextToken();
            if(activity.equals("enter")){
                employee.add(name);
            } else {
                employee.remove(name);
            }
        }
        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(String name : employee){
            pq.offer(name);
        }
        while(!pq.isEmpty()){
            bw.write(pq.poll() + "\n");
        }
        bw.flush();
    }
}
