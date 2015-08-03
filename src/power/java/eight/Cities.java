/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package power.java.eight;

import java.util.Arrays;
import java.util.List;

/**
 * @author tasha.jeon
 * @since 15. 8. 1.
 */
public class Cities {

    public static void main(final String[] args) {
        List<String> cities = Arrays.asList("Albany", "Boulder", "Chicago", "Denver", "Eugene");

        findChicagoImperative(cities);
        findChicagoDeclarative(cities);
    }

    /**
     * 기존 자바의 명령형 스타일(Impreative Style) 이다. 언뜻봐도 이 코드는 깔끔하지 않고 너무 자세하게 코딩되어 있다.
     * @param cities
     */
    public static void findChicagoImperative(List<String> cities) {
        boolean found = false;
        for(String city : cities) {
            if(city.equals("Chicago")) {
                found = true;
                break;
            }
        }
        System.out.println("Found chicago?:" + found);
    }

    /**
     * 서술적 스타일(Declarative style)의 한 예이다.
     * @param cities
     */
    public static void findChicagoDeclarative(List<String> cities) {
        System.out.println("Found chicago?:" + cities.contains("Chicago"));
    }
}
