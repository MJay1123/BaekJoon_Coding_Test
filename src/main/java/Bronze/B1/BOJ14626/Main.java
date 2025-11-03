package Bronze.B1.BOJ14626;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ISBN = br.readLine();
        int sum = 0;
        int index = -1;
        for(int i=0; i<ISBN.length(); i++) {
            if (ISBN.charAt(i) == '*') {
                index = i;
            } else {
                if (i % 2 == 0) {
                    sum += (ISBN.charAt(i) - '0');
                } else {
                    sum += (ISBN.charAt(i) - '0') * 3;
                }
            }
        }
        int num = 10 - (sum % 10);
        int k = (index % 2 == 0) ? 1 : 3;
        int answer = 0;
        for(int i=0; i<=9; i++){
            if(k * i % 10 == num){
                answer = i;
                break;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
