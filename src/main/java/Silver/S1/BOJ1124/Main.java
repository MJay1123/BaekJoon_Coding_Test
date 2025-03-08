package Silver.S1.BOJ1124;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 언더프라임
public class Main {
    static int A;
    static int B;       // 범위 : A~B(닫힌 구간)
    static boolean[] primeNumbersArray;
    static List<Integer> primeNumbersList = new ArrayList<>();
    static int underPrime = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        primeNumbersArray = new boolean[B+1];
        getPrimeNumbers();

        for(int i=A; i<=B; i++) {
            int num = i;
            int count = 0;
            while(num > 1){
                for(int primeNumber : primeNumbersList){
                    if(num % primeNumber == 0){
                        num /= primeNumber;
                        count++;
                        break;
                    }
                }
            }
            if(!primeNumbersArray[count]){
                underPrime++;
            }
        }
        bw.write(underPrime + "\n");
        bw.flush();
    }

    public static void getPrimeNumbers(){       // false가 소수
        primeNumbersArray[0] = true;
        primeNumbersArray[1] = true;
        for(int i=2; i<=Math.sqrt(B); i++){
            if(!primeNumbersArray[i]){               // i가 소수라면
                primeNumbersList.add(i);
                for(int j=2; i*j<=B; j++){
                    primeNumbersArray[i*j] = true;     // i의 배수들을 전부 합성수로 처리
                }
            }
        }
        for(int i=(int)Math.sqrt(B)+1; i<=B; i++){
            if(!primeNumbersArray[i]){
                primeNumbersList.add(i);
            }
        }
    }
}
