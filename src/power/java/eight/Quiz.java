package power.java.eight;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created with IntelliJ IDEA.
 * User: suhyunjeon
 * Date: 2015. 8. 1.
 * Time: 오후 9:01
 * To change this template use File | Settings | File Templates.
 */
public class Quiz {

    /*
        1. Projecteuler 문제
            10미만의 자연수에서 3과 5의 배수를 구하면 3,5,6,9이다. 이들의 총합은 23이다.
            1000미만의 자연수에서 3,5의 배수의 총합을 구하라.
     */

    private static int currentVersion(int size) {
        int totalSum = 0;
        for(int i=0; i<size; i++) {
            if( (i % 3 == 0) || (i % 5 == 0) ) totalSum += i;
        }
        return totalSum;
    }

    private static int lambdaVersion(int size) {
        return IntStream.range(1, size).filter(j -> (j % 3 == 0) || (j % 5 == 0)).sum();
    }


     /*
        2. Daum communication 입사 시험 문제
           1차원의 점들이 주어졌을 때, 그 중 가장 거리가 짧은 것의 쌍을 출력하는 함수를 작성하시오. (단 점들의 배열은 모두 정렬되어있다고 가정한다.)
           예를들어 S={1, 3, 4, 8, 13, 17, 20} 이 주어졌다면, 결과값은 (3, 4)가 될 것이다.
     */

    private static String minDistance(int[] intArray) {
        int minus = 0;
        Map<Integer, String> map = new HashMap<Integer, String>();
        for(int i = 0; i < intArray.length - 1; i++) {
            minus = intArray[i+1] - intArray[i];
            map.put(minus, intArray[i] + "," + intArray[i+1]);
        }

        Map.Entry<Integer, String> next = map.entrySet().iterator().next();
        return next.getValue();
    }

    private static String newMinDistance(int[] intArray) {

        return "";
    }

    public static void main(String args[]) {
//        System.out.printf("정답: %,d\n", currentVersion(1000));
//        System.out.printf("정답: %,d", lambdaVersion(1000));

        int[] intArray = {1, 3, 4, 8, 13, 17, 20};
        System.out.println(minDistance(intArray));
    }

}
