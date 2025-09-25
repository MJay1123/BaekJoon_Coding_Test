package Bronze.B1.BOJ24416;

import java.io.*;

public class Main {
    static int fib1Count = 0;
    static int fib2Count = 0;
    static int[] countArray = new int[41];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        fib1(n);
        fib2(n);
        bw.write(fib1Count + " " + fib2Count + "\n");
        bw.flush();
    }

    public static int fib1(int n){
        if(n==1 || n==2){
            fib1Count++;
            return 1;
        }
        return fib1(n-1) + fib1(n-2);
    }

    public static void fib2(int n){
        countArray[1] = 1;
        countArray[2] = 1;
        for(int i=3; i<=n; i++){
            fib2Count++;
            countArray[i] = countArray[i-1] + countArray[i-2];
        }
    }
}
