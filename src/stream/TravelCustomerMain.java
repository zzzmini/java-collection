package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TravelCustomerMain {
    static void main(String[] args) {
        // Customer 를 리스트에 담도록 선언
        List<Customer> customerList = new ArrayList<>();

        customerList.add(new Customer("이순신", 40, 100));
        customerList.add(new Customer("김유신", 20, 100));
        customerList.add(new Customer("홍길동", 13, 50));
        // 1. 전체 명단을 출력
        System.out.println("1. 전체 명단을 출력");
        customerList.stream()
                .forEach(x -> System.out.println(x));
        // 2. 이름만 출력
        System.out.println("2. 이름만 출력");
        customerList.stream()
                .map(x -> x.getName())
                .forEach(x -> System.out.println(x));

        // 3. 총 여행 비용
        System.out.println("3. 총 여행 비용");
        int totalPrice = customerList.stream()
                .mapToInt(x -> x.getPrice())
                .sum();
        System.out.println("총 여행경비 : " + totalPrice);
        // 4. 20세 이상 데이터의 이름만 오름차순 출력
        // stream -> filter -> map -> sorted -> foreach
        System.out.println("4. 20세 이상 데이터의 이름만 오름차순 출력");
        customerList.stream()
                .filter(x -> x.getAge() >= 20)
                .map(x -> x.getName())
                .sorted()
                .forEach(x -> System.out.println(x));
        // 5. 20세 아싱 전체 자료를 이름에 대한 내림차순
        System.out.println("5. 20세 아싱 전체 내림차순");
        // 자바 또는 자바스크립트에서 정렬은 늘 문제
        customerList.stream()
                .filter(x -> x.getAge() >= 20)
                // 클래스 내부의 별도 필드를 기준으로 정렬할 때
                .sorted(Comparator.comparing(
                        Customer::getName
                ).reversed())
                .forEach(x -> System.out.println(x));
    }
}
