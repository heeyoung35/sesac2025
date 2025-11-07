package com.ohgiraffers.section02;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        List<OnLineCourse> courses = Arrays.asList(
                new OnLineCourse("java의 정석", "Programming" , 120, false),
                new OnLineCourse("스프링 완전정복", "Programming" , 300, false),
                new OnLineCourse("JPA 끝장내기", "Programming" , 240, false),
                new OnLineCourse("포토샵 마스터", "Design" , 90, true),
                new OnLineCourse("일러스트레이터 시작하기", "Design" , 110, true),
                new OnLineCourse("SQL 첫걸음", "Database" , 80, true),
                new OnLineCourse("데이터베이스 모델링", "Database" , 150, false)
        );

        /* 프로그래밍 카테고리 중 수강 시간 200분 초과인 강의 제목 출력하기 */

        // for, if 사용
        for(OnLineCourse c : courses) {
            if("Programming".equals(c.getCategory()) && c.getDuration() > 200) {
                System.out.println(c.getTitle());
            }
        }

        courses.stream()// 모든 강의를 흘려보내서
                .filter(c -> "Programming".equals(c.getCategory()))// 프로그래밍이 포함된 카테고리
                .filter(c -> c.getDuration() > 200) // 수업시간이 200분 이상인 것의
                .map(OnLineCourse::getTitle) // 타이틀
                .forEach(System.out::println); // 메소드

        /* 중간 연산*/
        // sorted
        courses.stream()
                .filter(OnLineCourse::isFree)
                // Comparator를 람다식으로 구현!! 시간이 짧은 강의로 오름차순 정렬
                .sorted((c1, c2) -> c1.getDuration() - c2.getDuration())
                .forEach(System.out::println);

        // distinct : 중복 제거하기
        courses.stream()
                .map(OnLineCourse::getCategory)
                .distinct()
                .forEach(System.out::println);


        /* 최종 연산 숫자 전용 */

        // collect
        List<OnLineCourse> designCourses = courses.stream()
                .filter(c -> "Design".equals(c.getCategory()))
                .collect(Collectors.toList());
        System.out.println(designCourses);

        // 간단한 통계 구현
        // count() :  스트림에 남아있는 요소 개수 확인
        // sum() : 남은 요소의 합계
        // average() : 남은 요소의 평균
        int totalDurationOfFreeCourse = courses.stream()
                .filter(OnLineCourse::isFree)
                .mapToInt(OnLineCourse::getDuration) // mapToInt : IntStreamㅇ로 변환 (sum() 수행 가능)
                .sum();
        System.out.println(totalDurationOfFreeCourse + "분");

        /* groupingBy : */
        // 모든 강의를 카테고리 별로 분류해서 정리하기
        // collect에게 groupingBy를 할건데 기준은 카테고리야 라고 알려주면
        // 스트림이 알아서 Map<카테고리, 해당 강의 리스트> 형태로 분류해줌
        Map<String, List<OnLineCourse>> courseByCategory = courses.stream()
                .collect(Collectors.groupingBy(OnLineCourse::getCategory)); // getCategory가 키가 되고 map으로 반환

        //map 출력
        courseByCategory.forEach((category, coursesList) -> {
            System.out.println("[" + category + "]");
            coursesList.forEach( c -> System.out.println("- " + c.getTitle()));
        });
     }
}
