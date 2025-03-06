package Silver.S4.BOJ2839;

import java.io.*;

// 설탕 배달
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while(N % 5 != 0){
            N -= 3;
            count++;
        }
        if(N < 0){
            count = -1;
        } else {
            count += N / 5;
        }

        bw.write(count + "\n");
        bw.flush();
    }
}
