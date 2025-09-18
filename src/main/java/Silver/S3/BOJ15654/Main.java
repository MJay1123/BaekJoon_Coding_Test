package Silver.S3.BOJ15654;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] numbers;
    static boolean[] visited;
    static List<int[]> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        permutation(0, new ArrayList<Integer>(), M);
        for(int i = 0; i<result.size(); i++){
            int[] array = result.get(i);
            for(int num : array){
                bw.write(num + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    public static void permutation(int depth, List<Integer> out, int M){
        if(depth == M) {
            int[] array = new int[M];
            for(int i=0; i<out.size(); i++){
                array[i] = out.get(i);
            }
            result.add(array);
            return;
        }
        for(int i=0; i<numbers.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out.add(numbers[i]);
                permutation(depth+1, out, M);
                visited[i] = false;
                out.remove(out.size()-1);
            }
        }
    }
}
