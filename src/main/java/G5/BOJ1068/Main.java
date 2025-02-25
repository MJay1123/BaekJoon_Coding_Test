package G5.BOJ1068;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 트리
public class Main {

    static int N;                   // 노드의 개수
    static boolean[] notLeaf;       // 방문 배열
    static int[] parents;           // 부모 노드를 가리키는 배열
    static boolean[] deleted;       // 지워지는 노드를 가리키는 배열
    static int delete;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parents = new int[N];
        notLeaf = new boolean[N];
        deleted = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            parents[i] = Integer.parseInt(st.nextToken());
        }
        delete = Integer.parseInt(br.readLine());

        // ---------------------------------------------------
        deleteNode(delete);

        for(int i=0; i<N; i++){
            if(parents[i] == -1){
                leafCheck(i);
            }
        }

        int count = 0;
        for(int i=0; i<N; i++){
            if(!deleted[i] && !notLeaf[i]){
                count++;
            }
        }
        bw.write(count + "\n");
        bw.flush();
    }

    public static void leafCheck(int num){
        for(int i=0; i<N; i++){
            if(parents[i] == num && !notLeaf[i] && !deleted[i]){
                notLeaf[num] = true;
                leafCheck(i);
            }
        }
    }

    public static void deleteNode(int num){
        deleted[num] = true;
        for(int i=0; i<N; i++){
            if(parents[i] == num && !deleted[i]){
                deleteNode(i);
            }
        }
    }
}
