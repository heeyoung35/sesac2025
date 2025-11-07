package com.ohgiraffers.section01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        // Stream : 자바개발자들이 만든 도구. 파일 입출력에서 길 or 통로
        // 컬렉션을 사용할 때 스트림 메서드를 사용해서 데이터를 흐르도록 하는 것
        // 데이터 가공 조립을 통해 원하는 결과를 얻는다.

        // 테스용 데이터 리스트
        List<String> names = Arrays.asList("홀길동", "유관순", "이순신" , "신사임당", "장보고", "강감찬", "이성계");

        // 기존 방식 : for-each문을 사용한 외부 반복
        for(String name : names) {
            System.out.println(name);
        }
        System.out.println("--------------");
        // [스트림 방식] forEach를 사용한 내부 반복
        names.stream().forEach(name -> System.out.println(name)); // 노란 경고줄은 메소드 참조로 변경할 수 있다고 알려줌

        /*  스트림 파이프라인 조립하기
        *
        * 요구사항 : 이름이 4글자인 사람만 찾아서, "🍓신사임당🍓" 과 같은 형태로 변환하여 출력하라
        * */
        for(String name : names) {
            if(name.length() == 4) {
                String decoratedName = "🍓" + name + "🍓";
                System.out.println(decoratedName);
            }
        }

        System.out.println("-----------");

        names.stream()
                .filter(name -> name.length() == 4) // 하나하나 반복하는 name이 4개인 것을 확인해서 통과 된 것만 파이프라인 아래로 통과된다.
                .map(name -> "🍓" + name +"🍓") // 데이터를 가공 필터를 통과한 이름을 받아서 이렇게 변환 하겠다.
                .forEach(decoratedName -> System.out.println(decoratedName)); // 필터와 맵을 통해 가공한 이름을 받아서 화면에 출력하겠다.

        /* 스트림 결과물 만들기 : collect
        *
        * 요구사항 : 성이 '이'씨인 사람들을 찾아서, 알파벳 순서로 정렬한 후, 새로운 list로 만들어라.
        * */

        List<String> leeFamily = names.stream()
                .filter(name -> name.startsWith("이")) // 이씨인 사람만 필터링을 통해 true값으로 확인
             // .sorted()  // 가나다 순으로정렬 파이프 라인 중간에서 정렬
                .sorted(Comparator.reverseOrder()) // 역순으로 정렬
                .collect(Collectors.toList()); // 최종 결과물들을 새로운 List로 수집

        System.out.println("이씨 가문 사람들 : " + leeFamily);

        // 1. count() : 조건에 맞는 요소의 개수 세기
        long leeCount = names.stream()
                .filter(name -> name.startsWith("이"))
                .count();  //  스트림에 남은 요소의 개수를 반환
        System.out.println(leeCount);

        // 2.anyMatch() : 조건에 맞는 요소가 하나라도 있는지 확인
        boolean hasJang = names.stream()
                .anyMatch(name -> name.equals("장보고"));
        System.out.println(hasJang);

        // 3. allMatch() : 모든 요소가 조건을 만족하는지 확인
        boolean isAllThreeLetters = names.stream()
                .allMatch(name -> name.length() == 3); // 모든 요소가 조건을 만족하면 true
        System.out.println(isAllThreeLetters);  // 출력값 false

    }


}
