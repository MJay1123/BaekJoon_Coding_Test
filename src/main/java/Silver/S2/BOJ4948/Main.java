package Silver.S2.BOJ4948;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] primeNumber = new boolean[123456*2+1];
        for(int i=0; i<primeNumber.length; i++){
            if(i == 0 || i == 1){
                primeNumber[i] = true;
            }
            if(!primeNumber[i]){
                for(int j=2; i*j<primeNumber.length; j++){
                    primeNumber[i*j] = true;
                }
            }
        }
        while(true){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                break;
            }
            int count = 0;
            for(int i=num+1; i<=num*2; i++){
                if(!primeNumber[i]){
                    count++;
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
    }
}
