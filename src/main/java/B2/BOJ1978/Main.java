package B2.BOJ1978;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            boolean primeNumber = true;
            if(num == 1){
                primeNumber = false;
                continue;
            }
            for(int j=2; j<num; j++){
                if(num % j == 0){
                    primeNumber = false;
                }
            }
            if(primeNumber){
                count++;
            }
        }
        bw.write(count + "\n");
        bw.flush();
    }
}
