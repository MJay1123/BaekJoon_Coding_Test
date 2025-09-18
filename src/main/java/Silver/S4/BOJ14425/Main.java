package Silver.S4.BOJ14425;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] array = new String[N];
        for(int i=0; i<N; i++){
            array[i] = br.readLine();
        }
        int answer = 0;
        for(int i=0; i<M; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                if(array[j].equals(str)){
                    answer++;
                    break;
                }
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
