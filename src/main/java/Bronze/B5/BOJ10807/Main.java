package Bronze.B5.BOJ10807;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num == v){
                answer++;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
