package Bronze.B2.BOJ2292;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int sum = 1;
        int i=0;
        while(true){
            sum += 6*i;
            if(sum >= N){
                break;
            }
            i++;
        }
        bw.write(i+1 + "\n");
        bw.flush();
    }
}
