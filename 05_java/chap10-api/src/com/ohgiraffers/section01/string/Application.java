package com.ohgiraffers.section01.string;

public class Application {
    public static void main(String[] args) {

        String rawData = "     [PROD-001] Apple iPhone 16Rro | a17 bionic | 2500000    ";
        System.out.println(rawData);

        // trim() : 분자열의 불필요한 앞/뒤 공백을 제거하여 데이터를 정제할 수 있다.
        String trimmedData = rawData.trim();
        System.out.println(trimmedData);

        /* toUpperCase() / toLowerCase(): 문자열을 일관된 대/소문자로 변환하여 비교나 검색 시 오류를 줄인다.*/
        String upperData = trimmedData.toUpperCase();
        System.out.println("대문자로 변환 : " + upperData);

        /* indexOf() : 특정 문자으 위치(인덱스)를 찾아내어 원하는 데이터를 추출할 기준점으로 삼을 수 있다. */
        int codeStartIndex = upperData.indexOf('[') + 1;
        int codeEndIndex = upperData.indexOf(']');
        int nameEndIndex = upperData.indexOf('|');
        System.out.println(codeStartIndex); // 출력값 1
        System.out.println(codeEndIndex);  // 출력값 9

        /* substring(시작 인덱스, 끝 인덱스) : 문자열의 특정 구간을 잘라내어 새로운 문자열로 반환한다. */
        // substring(0,5)라고 한다면 5번 이전 4번까지 잘라온다.
        String productCode = upperData.substring(codeStartIndex, codeEndIndex);
        String productName= upperData.substring(codeEndIndex + 1, nameEndIndex).trim();

        System.out.println(productCode);
        System.out.println(productName);

        /* replace() : 문자열 냉의 특정 문자(열)를 다른 문자열로 칭환한 새로운 문자열을 반환한다.*/
        String replaceName = productName.replace("IPHONE 16RRO", "GALAXY S25 ULTRA");
        System.out.println(replaceName);

        String str1 = "java"; // 리터럴 방식은 자바에서 string constant pool에서 찾는다.
        String str2 = "java"; // 다시 만들면 새로 만드는 것이 아니라 기존의 것에 주소를 같이 사용한다. 내용과 주소가 같다.
        String str3 = new String("java"); // new 연산자 방식은 heap 메모리에 새로운 것을 만든다
        String str4 = new String("java"); // 그래서 내용은 같지만 주소값을 다르게 가진 같은 내용을 가진 새로운 객체가 생성된다. 주소값이 다르다.

        // new String() -> 매번 새로운 객체를 heap 메모리에 생성한다(내용이 같아도 주소값이 다 다름)
        System.out.println("str1 == str2: " + (str1 == str2));  // true 출력
        System.out.println("str3 == str4: " + (str3 == str4));  // false 출력
        /* !! 따라서 문자열의 '내용'을 비교할 때는 반드시 '.equals()' 메소드를 사용해야 한다
        *  .equals()는 String 클래스에서 주소 비교가 아닌, 문자열 값 자체를 비교하도록 오버라이딩 되어있다. */

        System.out.println("str3.equals(str4) : " + str3.equals(str4));  // 값이 같기 때문에 true

        /* 문자열은 '불변(immutable)' 객체이다.
        * '+' 연산 등으로 문자열을 변경하면 기존 문자열이 수정되는 것이 아니라,
        * 새로운 문자열 객체가 생성되고 참조 주소가 바뀌게 된다.
        * */

        str2 += "mysql";  // 문자열을 합친 새로운 객체가 생성
        System.out.println("str1 == str2 : " + (str1 == str2)); // str1 과 str2가 같았었는데 문자열이 변경되면서 새롭게 생성된다.
        // false 출력 이전의 주소값에 문자열만 합친 것이 아니라 새롭게 객체를 생성해서 주소값이 다르다.

        /* split()* : 특정 구분자를 기준으로 문자열을 잘라 '문자열 배열'로 반환한다. */
        String emp = "100/홍길동/서울//영업부";
        String[] empArr = emp.split("/");

        for(String info : empArr) {
             /*
             100
            홍길동
            서울

            영업부
            */
            // .isEmpty() : 문자열의 길이가 0이면  true, 아니면 false 반환
            if(info.isEmpty()) {
                System.out.println("정보 없음");
            } else {
                System.out.println(info);
            }
        }
        /* 이스케이프 문자
        *  문자열 내에서 줄바꿈, 탭, 따옴표 등 특별한 기능을 하는 문자, 역슬레시 (\)로 시작한다.
        * \n(줄바꿈), \t(탭), \"(쌍따옴표), \'(따옴표), \\(역슬래시)
        * */

        System.out.println("안녕하세요.\n저는 개발자입니다.");
        System.out.println("제 주특기는 \t 'Java'와 \" Spring\" 입니다.");
        System.out.println("파일 경로는 C:\\Users\\student 입니다.");
    }
}
