package Silver.S4.BOJ1269;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<n; i++){
            int number = Integer.parseInt(st.nextToken());
            hs.add(number);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int number = Integer.parseInt(st.nextToken());
            if(hs.contains(number)){
                hs.remove(number);
            } else {
                hs.add(number);
            }
        }
        bw.write(hs.size() + "\n");
        bw.flush();
    }
}
