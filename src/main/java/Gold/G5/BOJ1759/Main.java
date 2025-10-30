package Gold.G5.BOJ1759;

import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<String> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        // 최소 1개의 모음(a,e,i,o,u) + 최소 2개의 자음
        st = new StringTokenizer(br.readLine());
        char[] arr = new char[C];
        PriorityQueue<Character> pqTemp = new PriorityQueue<>();
        for(int i=0; i<C; i++){
            pqTemp.offer(st.nextToken().charAt(0));
        }
        boolean[] vowel = new boolean[C];
        for(int i=0; i<C; i++){
            arr[i] = pqTemp.poll();
            if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'){
                vowel[i] = true;
            }
        }
        boolean[] visited = new boolean[C];
        use(arr, vowel, visited, 0, 0, L, 0);
        bw.write(sb.toString());
        bw.flush();
    }
    public static void use(char[] arr, boolean[] vowel, boolean[] visited, int vowelCount, int consonantCount, int L, int index) {
        if (vowelCount + consonantCount == L && vowelCount >= 1 && consonantCount >= 2) {
            for (int i = 0; i < visited.length; i++){
                if(visited[i]) {
                    sb.append(arr[i]);
                }
            }
            sb.append("\n");
            return;
        }
        if(index == visited.length){
            return;
        }
        visited[index] = true;
        if (vowel[index]) {
            use(arr, vowel, visited, vowelCount + 1, consonantCount, L, index + 1);
        } else {
            use(arr, vowel, visited, vowelCount, consonantCount + 1, L, index + 1);
        }
        visited[index] = false;
        use(arr, vowel, visited, vowelCount, consonantCount, L, index+1);
    }
}
