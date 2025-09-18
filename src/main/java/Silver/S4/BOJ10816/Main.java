package Silver.S4.BOJ10816;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<N; i++){
            int number = Integer.parseInt(st.nextToken());
            if(hm.containsKey(number)){
                hm.replace(number, hm.get(number) + 1);
            } else {
                hm.put(number, 1);
            }
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            int number = Integer.parseInt(st.nextToken());
            if(hm.containsKey(number)){
                sb.append(hm.get(number));
            } else {
                sb.append("0");
            }
            sb.append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
