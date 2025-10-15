package Bronze.B2.BOJ25501;

import java.io.*;

public class Main {
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            answer = 0;
            String S = br.readLine();
            bw.write(isPalindrome(S) + " " + answer + "\n");
        }
        bw.flush();
    }

    public static int recursion(String S, int l, int r){
        answer++;
        if(l >= r){
            return 1;
        } else if(S.charAt(l) != S.charAt(r)){
            return 0;
        } else {
            return recursion(S, l+1, r-1);
        }
    }

    public static int isPalindrome(String S){
        return recursion(S, 0, S.length()-1);
    }
}
