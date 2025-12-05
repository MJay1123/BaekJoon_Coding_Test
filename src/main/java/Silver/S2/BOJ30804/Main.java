package Silver.S2.BOJ30804;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] fruits = new int[N];
        HashSet<Integer> leftHS = new HashSet<>();
        HashSet<Integer> rightHS = new HashSet<>();
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        for(int i=0; i<N; i++){
            fruits[i] = Integer.parseInt(st.nextToken());
            if(!leftHS.contains(fruits[i])){
                leftHS.add(fruits[i]);
                leftList.add(i);
            }
        }
        for(int i=N-1; i>=0; i--){
        }

    }
}
