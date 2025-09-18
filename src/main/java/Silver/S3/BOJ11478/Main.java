package Silver.S3.BOJ11478;

import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String string = br.readLine();
        HashSet<String> hs = new HashSet<>();
        for(int i=0; i<string.length(); i++){
            for(int j=i+1; j<=string.length(); j++){
                String str = string.substring(i, j);
                hs.add(str);
            }
        }
        bw.write(hs.size() + "\n");
        bw.flush();
    }
}
