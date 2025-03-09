package Silver.S4.BOJ1235;

import java.io.*;
import java.util.HashSet;

// 학생 번호
public class Main {
    static int N;       // 학생의 수
    static String[] numbers;
    static HashSet<String> hs = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        numbers = new String[N];
        for(int i=0; i<N; i++){
           numbers[i] = br.readLine();
        }
        // 문제 풀이
        int length = 1;
        while(true){
            hashSetFill(length);
            if(hs.size() == N){
                break;
            }
            length++;
        }
        bw.write(length + "\n");
        bw.flush();
    }

    public static void hashSetFill(int length){
        hs.clear();
        for(int i=0; i<N; i++) {
            String str = numbers[i].substring(numbers[i].length() - length);
            hs.add(str);
        }
    }
}
