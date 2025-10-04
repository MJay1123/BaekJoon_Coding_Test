package Silver.S3.BOJ1735;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[] primeNumber;
    static int answerA;
    static int answerB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int b1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int a2 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());
        primeNumber = new boolean[30001];
        primeNumber[0] = true;
        primeNumber[1] = true;
        for(int i=2; i<=600; i++){
            if(!primeNumber[i]){
                for(int j=2; i*j<primeNumber.length; j++){
                    primeNumber[i*j] = true;
                }
            }
        }
        answerB = b1 * b2;
        answerA = a1 * b2 + b1 * a2;
        for(int i=2; i<=30000; i++){
            if(!primeNumber[i] && answerB % i == 0 && answerA % i == 0){
                answerB /= i;
                answerA /= i;
                i = 1;
            }
        }
        bw.write(answerA + " " + answerB);
        bw.flush();
    }
}
