package Silver.S3.BOJ1270;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

// 전쟁 - 땅따먹기
public class Main {
    static int n;       // 땅의 개수
    static HashMap<Long, Integer> soldiers = new HashMap<>();
    static long domainTroop;
    static int number;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for(int field=0; field<n; field++){
            soldiers.clear();
            domainTroop = 0;
            st = new StringTokenizer(br.readLine());
            number = Integer.parseInt(st.nextToken());
            for(int i=0; i<number; i++) {
                long army = Long.parseLong(st.nextToken());
                addMap(army);
            }
            if(domainTroop == 0){
                bw.write("SYJKGW" + "\n");
            } else {
                bw.write(domainTroop + "\n");
            }
        }
        bw.flush();
    }

    public static void addMap(long army){
        if(soldiers.containsKey(army)){
            soldiers.replace(army, soldiers.get(army) + 1);
        } else {
            soldiers.put(army, 1);
        }
        if(soldiers.get(army) > number / 2){
            domainTroop = army;
        }
    }
}
