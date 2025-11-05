package com.ohgiraffers.section01.list.run;

import java.util.LinkedList;
import java.util.Queue;

public class Application5 {
    public static void main(String[] args) {
        /* Queue (큐)
        * - 선입선출(FIFO) 방식의 자료구조이다.
        * - 큐는 인터페이스이므로, 실제로는 이를 구현한 LinkedList등의 클래스를 사용해 인스턴스를 생성한다.
        * - 인터페이스는 자기 자신의 객체를 생성할 수 없다.
        * */

        Queue<String> que = new LinkedList<>(); // 인터페이스이기 때문에 LinkedList로 생성

        /* 데이터를 넣을 때는 offer()를 사용 */
        que.offer("first");  // 가장 먼저 들어간 데이터
        que.offer("second");
        que.offer("third");

        System.out.println(que);

        // 가장 앞에 있는 요소를 '확인만' 하고 제거하지 않음
        System.out.println("peek()" + que.peek());
        System.out.println(que);

        // poll() : 가장 앞에 있는 요소를 꺼내고 큐에서 제거한다.
        System.out.println("poll() : " + que.poll());
        System.out.println(que);

        // 큐가 비어있는 경우 null을 반환한다.
        que.poll();
        que.poll();  // 여기서 다 비워진 상태!
        System.out.println(que.poll());   // null출력
    }
}
