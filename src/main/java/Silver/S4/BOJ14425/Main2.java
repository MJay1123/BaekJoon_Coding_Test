package Silver.S4.BOJ14425;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> hs = new HashSet<>();
        for(int i=0; i<N; i++){
            hs.add(br.readLine());
        }
        int answer = 0;
        for(int i=0; i<M; i++){
            String str = br.readLine();
            if(hs.contains(str)){
                answer++;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
