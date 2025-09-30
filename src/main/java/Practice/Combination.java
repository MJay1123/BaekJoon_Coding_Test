package Practice;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        boolean[] visited = new boolean[5];
        int r = 3;
        combination(arr, visited, 0, 0, r);
        System.out.println(result);
        System.out.println(result.size());
    }

    public static void combination(int[] arr, boolean[] visited, int index, int depth, int r){
        if(depth == r){
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<arr.length; i++){
                if(visited[i]){
                    list.add(arr[i]);
                }
            }
            result.add(list);
            return;
        }
        if(index == arr.length){
            return;
        }
        visited[index] = true;
        combination(arr, visited, index+1, depth+1, r);
        visited[index] = false;
        combination(arr, visited, index+1, depth, r);
    }
}
