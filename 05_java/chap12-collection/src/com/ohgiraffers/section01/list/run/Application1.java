package com.ohgiraffers.section01.list.run;

import org.w3c.dom.DOMStringList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// collection(list, Queue, Set) 종류
public class Application1 {
    public static void main(String[] args) {

        /* 컬렉션 프리임워크란:
        * - 여러 개의 데이터(객체)를 효과적으로 관리하기 위해 자바에서 제공하는 클래스들의 묶음
        * - 크게 List, Set, Map 인터페이스로 분류된다.
        * */

        /*
        * ArrayList
        * - List 인터페이스의 가장 대표적인 구현 클래스
        * - 데이터에 순서(인덱스)가 있고, 중복된 데이터 저장을 허용한다.
        * - 내부적으로는 배열을 사용햐여 데이터를 관리한다.
        * */

        // 제네릭을 사용하지 않고도 만들 수 있다.
//      ArrayList alist = new ArrayList();

        List alist = new ArrayList();  // 다형성을 이용해서 부모의 인터페이스 사용
        alist.add("apple");
        alist.add(123);
        alist.add(45.67);
        alist.add(false);

        // 출력값 제네릭 없는 alist = [apple, 123, 45.67, false]
        // 오브젝트 타입으로 취급하기 때문에 내가 추론해서 강제 형변환 필요
        System.out.println("제네릭 없는 alist = " + alist);

        // 제네릭을 지정하지 않으면 리스트에 저장된 요소들이 오브젝트 타입으로 취급된다.
        // 따라서 값을 꺼내서 원래 타입으로 사용하려면, 매번 형변환을 해야 한다.
        // 컬렉션을 사용할 때 제네릭을 사용
        String fruit = (String) alist.get(0);

        /* 제네릭 사용*/
        List<String> stringList = new ArrayList<>();  // 문자열 타입만 지정
        stringList.add("banana");
        stringList.add("apple");
        stringList.add("orange");
        stringList.add("mango");
//        stringList.add(123);   // 제네릭 지정으로 컴파일 에러발생
        stringList.add("mango"); // 중복 저장 가능

        System.out.println(stringList);

        /* 리스트 정렬하기 */
        /* Collections 클래스는 컬렉션을 다루는데 유용한 static 메소드들을 제공하는 유틸리티 클래스이다.
        * (Collection 인터페이스와 다름!!)
        * */

        // 오름차순 정렬
        Collections.sort(stringList);

        System.out.println("오름차순 정렬 후 : " + stringList);

        // 내림차순 정렬
        // List 인터페이스에서 제공하는 sort 메소드에 Comparator.reverseOrder()를 인자로 전달
        stringList.sort(Comparator.reverseOrder()); //Comparator.reverseOrder() 내림차순 정렬
        System.out.println("내림차순 정렬 후 : " + stringList);

    }
}
