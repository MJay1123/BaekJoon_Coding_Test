package Silver.S4.BOJ4134;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long T = Long.parseLong(br.readLine());
        for(long t=0; t<T; t++){
            long n = Long.parseLong(br.readLine());
            bw.write(findNext(n) + "\n");
        }
        bw.flush();
    }

    public static long findNext(long num){
        if(num < 2){
            return 2L;
        }
        while(true){
            boolean temp = true;
            for(long i=2; i<=(long)Math.sqrt(num); i++){
                if(num % i == 0){
                    temp = false;
                    break;
                }
            }
            if(temp){
                return num;
            } else {
                num++;
            }
        }
    }
}
