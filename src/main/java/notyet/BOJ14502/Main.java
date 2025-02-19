package notyet.BOJ14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> virusRowList = new ArrayList<>();
    static List<Integer> virusColumnList = new ArrayList<>();
    static List<Boolean> virusBooleanList = new ArrayList<>();
    static List<Integer> emptyRowList = new ArrayList<>();
    static List<Integer> emptyColumnList = new ArrayList<>();
    static List<Boolean> emptyBooleanList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void dfs(int r, int c, int[][] arr){
        arr[r][c] = 2;
        if(r+1 < arr.length){
            if(arr[r+1][c] == 0){
                dfs(r+1, c, arr);
            }
        }
        if(r-1 >= 0){
            if(arr[r-1][c] == 0){
                dfs(r-1, c, arr);
            }
        }
        if(c+1 < arr[0].length){
            if(arr[r][c+1] == 0){
                dfs(r, c+1, arr);
            }
        }
        if(c-1 >= 0){
            if(arr[r][c-1] == 0){
                dfs(r, c-1, arr);
            }
        }
    }

    public static void getEmptyGraph(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == 2){
                    emptyRowList.add(i);
                    emptyColumnList.add(j);
                    emptyBooleanList.add(false);
                }
            }
        }
    }

    public static void getVirusGraph(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == 2){
                    virusRowList.add(i);
                    virusColumnList.add(j);
                    virusBooleanList.add(false);
                }
            }
        }
    }

}
