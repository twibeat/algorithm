package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 17..
 */
public class BJ10974 {
    public static boolean nextPermutation(int[] inputs){
        int i = inputs.length - 1;
        //뒤에서 부터 내림 차순이 안되는 i를 찾는다
        while(i > 0 && inputs[i-1] > inputs[i]) i -= 1;

        //마지막인 경우
        if(i <= 0) return false;

        //오름 차순이 안되는 j를 찾아 i와 바꾼다
        int j = inputs.length - 1;
        while(inputs[j] <= inputs[i-1]) j -= 1;

        int temp = inputs[i-1];
        inputs[i-1] = inputs[j];
        inputs[j] = temp;

        //스왑한다.
        j = inputs.length - 1;
        while(i < j){
            temp = inputs[i];
            inputs[i] = inputs[j];
            inputs[j] = temp;
            i += 1; j -= 1;
        }

        return true;
    }
    public static String allPermutation(int n){
        int[] inputs = new int[n];
        for(int i = 0; i < n; ++i){
            inputs[i] = i + 1;
        }

        StringBuilder output = new StringBuilder();
        update(output, inputs);

        while(nextPermutation(inputs)){
            update(output, inputs);
        }

        return output.toString();
    }

    private static void update(StringBuilder output, int[] inputs) {
        for(int value : inputs){
            output.append(value + " ");
        }
        output.append("\n");
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        int[] inputs = new int[n];
//        for(int i = 0 ;i < n; ++i){
//            inputs[i] = i + 1;
//            System.out.print(inputs[i] + " ");
//        }
//        System.out.println();
//        while(nextPermutation(inputs)){
//            for(int i = 0; i < n; ++i){
//                System.out.print(inputs[i] + " ");
//            }
//            System.out.println();
//        }
        //print를 여러번 사용하는 것보다 한번에 출력하는게 4배정도의 성능 향상이 있었음
        System.out.println(allPermutation(n));
    }
}
