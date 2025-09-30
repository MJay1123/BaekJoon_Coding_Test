package Silver.S3.BOJ15649;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = i+1;
        }
        boolean[] visited = new boolean[N];
        List<Integer> list = new ArrayList<>();
        permutation(arr, visited, 0, M, list);
        for(int i=0; i<result.size(); i++){
            list = result.get(i);
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<list.size(); j++){
                sb.append(list.get(j) + " ");
            }
            bw.write(sb.toString() + "\n");
        }
        bw.flush();
    }

    public static void permutation(int[] arr, boolean[] visited, int depth, int r, List<Integer> list){
        if(depth == r){
            List<Integer> ls = new ArrayList<>();
            for(int i=0; i<list.size(); i++){
                ls.add(list.get(i));
            }
            result.add(ls);
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(arr[i]);
                permutation(arr, visited, depth+1, r, list);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
