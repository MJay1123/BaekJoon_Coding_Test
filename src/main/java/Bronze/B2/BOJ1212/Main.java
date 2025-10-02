package Bronze.B2.BOJ1212;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        if(str.equals("0")){
            bw.write(0 + "\n");
            bw.flush();
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            int num = str.charAt(i) - '0';
            String num2 = Integer.toString(num, 2);
            while(num2.length() < 3){
                num2 = "0" + num2;
            }
            sb.append(num2);
        }
        String answer = sb.toString();
        answer = answer.substring(answer.indexOf("1"));
        bw.write(answer + "\n");
        bw.flush();
    }
}
