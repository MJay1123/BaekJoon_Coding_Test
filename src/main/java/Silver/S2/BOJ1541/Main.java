package Silver.S2.BOJ1541;

import java.io.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int start = 0;
        Integer temp = null;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '+' || str.charAt(i) == '-'){
                int number = Integer.parseInt(str.substring(start, i));
                if(number >= 0){
                    if(temp == null) {
                        answer += number;
                    } else {
                        temp += number;
                    }
                } else {
                    if(temp == null){
                        temp = -number;
                    } else {
                        answer -= temp;
                        temp = -number;
                    }
                }
                start = i;
            }
        }
        int number = Integer.parseInt(str.substring(start));
        if(number >= 0){
            if(temp == null) {
                answer += number;
            } else {
                temp += number;
            }
        } else {
            if(temp == null){
                temp = -number;
            } else {
                answer -= temp;
                temp = -number;
            }
        }
        if(temp != null) {
            answer -= temp;
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
