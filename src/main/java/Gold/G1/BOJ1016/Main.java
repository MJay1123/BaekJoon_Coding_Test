package Gold.G1.BOJ1016;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        boolean[] squareNoNo = new boolean[(int)(max-min+1)];
        for(long i=2; i*i<=max; i++){
            long squareNumber = i * i;
            if(squareNumber < min) {
                squareNumber *= (min / squareNumber);
                if(squareNumber != min){
                    squareNumber += i*i;
                }
            }
            for(long j=0; squareNumber+(i*i)*j<=max; j++){
                long index = squareNumber+(i*i)*j-min;
                if(!squareNoNo[(int)index]){
                    squareNoNo[(int)index] = true;
                }
            }
        }
        for(int i=0; i<squareNoNo.length; i++) {
            if (!squareNoNo[i]) {
                answer++;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
