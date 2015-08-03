/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package power.java.eight;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author tasha.jeon
 * @since 15. 8. 1.
 * 20 달러보다 전체 price 가 높으면 10%를 할인한다. 이 할인된 price 의 합을 구해보자.
 */
public class DiscountImperative {
    public static void main(final String[] args) {

        final List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
                new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
                new BigDecimal("45"), new BigDecimal("12"));

        sumPriceOldVersion(prices);
        sumPriceNewVersion(prices);

    }

    /**
     * 기존 자바 스타일의 코드이다. 앞서말한대로 언뜻봐도 이 코드 또한 깔끔하지 않고 너무 자세하게 코딩되어 있다.
     * @param prices
     */
    public static void sumPriceOldVersion(List<BigDecimal> prices) {
        BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;

        for(BigDecimal price : prices) {
            if(price.compareTo(BigDecimal.valueOf(20)) > 0)
                totalOfDiscountedPrices =
                        totalOfDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
        }
        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
    }

    /**
     * 기존 습관적 방법으로 작성된 코드보다 상당히 향상된 코드이다.
     * 사용한 메소들들은 파라미터로 anonymous function 어노니머스 함수-람다 표현식을 가진다.
     * @param prices
     */
    public static void sumPriceNewVersion(List<BigDecimal> prices) {
        BigDecimal totalOfDiscountedPrices =
            prices.stream()
                .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);
    }

    /**
     * 함수형 스타일 코드의 큰 이점
     *  1. 변수의 명시적인 변경이나 재할당의 문제를 피할 수 있다. 즉, 코드 안에서 발생할 수 있는 오류의 확률이 더 낮아진다는 의미이다.
     *
     *  2. 병렬화가 쉽다. 하나의 변수에 대한 처리가 끝난 후에야 그 변수에 대한 다음 엑세스를 할 수 있다. 이러한 점은 thread-safety 문제를 제거한다.
     *
     *  3. 서술적인 코드 작성이 가능하다.
     *
     *  4. 간결하다. 몇 줄의 코드만으로 명령형 버전과 같은 결과를 얻을 수 있다.
     *     <간결하다></간결하다>란 것은 짧고, 오류가 없으며 개발자의 의도를 효과적으로 전달하는 것이다.
     *
     *  5. 직관적이다. 사람이 문제를 설명하는 방식대로 코드를 작성하면 된다.
     */
}
