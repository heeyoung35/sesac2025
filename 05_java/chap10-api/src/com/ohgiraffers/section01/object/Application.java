package com.ohgiraffers.section01.object;
// 모든 자바의 클래스는 object라는 기본 기능을 상속받아서 사용하고 있다.
public class Application {
    public static void main(String[] args) {

        Book book1 = new Book(1, "홍길동", "허균", 5000);
        // new로 생성자를 만들면 heap영역에 메모리 주소는 다르다. 완전히 별개의 객체이다.
        Book book2 = new Book(2, "목민심서", "정약용", 3000);
        Book book3 = new Book(2, "목민심서", "정약용", 3000);


        // Book@2f4d3709출력 toString() 객체의 메모리를 중심으로 주소값 출력
        // toString을 오버라이드 하면 정보를 얻을 수 있다.
        /* object.toString() 기본기능은 '클래스명@해시코드'를 반환한다.
        *  사람이 보기에는 의미없는 정보이다. 따라서 객체의 필드 값을 보여주도록 오버라딩 하여 사용한다. */
        System.out.println("book1= " + book1);

        /*
        *  object.equals()의 기본 기능은 '==' 연산과 같이 두 객체의 주소 값을 비교한다.(동일성 비교)
        *  하지만, 때로는 주소가 달라도 필드의 내용이 같으면 '같다(동등하다)'고 판단해야 할 때가 있다.
        *  이런 동등성 비교를 위해 equals()를 오버라이딩 한다.
        * */
        System.out.println("동일성 비교(==) : " + (book2 == book3)); // 주소값
        System.out.println("동등성 비교(equals) : " + book2.equals(book3));
        // 객체의 내용이 같은지 비교 equals를 오버라이드 하지 않았기 때문에 주소값을 확인해서 false 로 충력
        // 동일 내용의 객체를 확인하기 위해서 우리만의 동등성을 이용하고자 할 때 동등성 비교로 만들 수 있다.

        /* 자바의 중요한 '일반 규약' : equals() 비교로 true를 반환한다면,
        *  두 객체의 hashCode() 값은 반드시 같아야 한다.
        *  나중에 배울 '자료구조' 기술에서 객체를 빠르고 효율적으로 찾기 위해 hashCode() 값으로 객체를 비교하는데
        *  만약 equals는 같다고 나오고 hashCode는 다르다면,
        *  컴퓨터가 이 두 객체를 완전히 다른것으로 착각하는 문제가 생길 수 있다.
        *  */
        // 자료구조에서 많은 데이터 속에서 특정 객체를 빨리 찾기 위해서 해시코드로 찾게된다.
        // 그렇기 때문에 동등성을 비교하기 위해서 오버라이드 했지만 해쉬코드로 비교하기 때문에 찾지 못한다.
        System.out.println(book2.hashCode());
        System.out.println(book3.hashCode());



    }
}
