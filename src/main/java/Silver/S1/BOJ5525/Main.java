package Silver.S1.BOJ5525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<M-2; i++){
            if(S.charAt(i) == 'I'){
                int count = 0;
                for(i=i+1; i<M-1; i+=2){
                    if(S.charAt(i) == 'O' && S.charAt(i+1) == 'I'){
                        count++;
                    } else {
                        i--;
                        break;
                    }
                }
                if(count > 0) {
                    list.add(count);
                }
            }
        }
        int answer = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i) >= N) {
                answer += (list.get(i) - N + 1);
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
