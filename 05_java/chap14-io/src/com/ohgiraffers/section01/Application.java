package com.ohgiraffers.section01;

import java.io.File;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {

        /*
        * 파일 클래스를 이용해서 인스턴스를 생성한다.
        * 대상 파일이 존재하지 않아도 인스턴스를 생상 할 수 있다.
        * */
        //이런 정보를 가진 파일 객체를 생성 파일 생서X
        File file = new File("src/com/ohgiraffers/section01/test.txt");

        try {
            // 파일 생성 후 성공 실패 여부를 boolean으로 리턴
            // 파일 입축력에 대한 예외가 발생하기 때문에 예외처리 해주는 컴파일 에러
            boolean createSuccess = file.createNewFile();   // 실제 파일 생성

            System.out.println(createSuccess);  // 파일 생성여부를 boolean으로 확인 존재하는 파일의 경우 false 출력

        } catch (IOException e) { // 경로가 오류인 경우 예외처리로 에러발생
            e.printStackTrace();
        }

        System.out.println("파일의 크기 : " + file.length() + "byte");
        System.out.println("파일의 경로 : " + file.getPath());
        System.out.println("파일의 절대 경로 : " + file.getAbsolutePath());

        // 파일 삭제
        boolean deleteSuccess = file.delete();

        System.out.println(deleteSuccess);
    }

}
