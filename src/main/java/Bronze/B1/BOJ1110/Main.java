package Bronze.B1.BOJ1110;

import java.io.*;

// 더하기 사이클
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int firstNum = Integer.parseInt(br.readLine());
        int count = 1;
        int number = process(firstNum);
        while(firstNum != number){
            number = process(number);
            count++;
        }
        bw.write(count + "");
        bw.flush();
    }

    public static int process(int number){
        int a = number % 10;
        int b = ((number / 10) + (number % 10)) % 10;
        return a * 10 + b;
    }
}
