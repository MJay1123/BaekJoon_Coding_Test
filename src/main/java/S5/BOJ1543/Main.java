package S5.BOJ1543;

import java.io.*;

// 문서 검색
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String full = br.readLine();
        String find = br.readLine();

        int count = 0;
        for(int i=0; i<full.length(); i++){
            if (check(full, find, i)) {
                count++;
                i += find.length()-1;
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean check(String full, String find, int num){
        if(num + find.length()-1 >= full.length()){
            return false;
        }
        int count = 0;
        for(int i=0; i<find.length(); i++){
            if(full.charAt(num+i) == find.charAt(i)){
                count++;
            }
        }
        if(count == find.length()){
            return true;
        } else {
            return false;
        }
    }
}
