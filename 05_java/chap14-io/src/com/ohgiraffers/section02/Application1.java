package com.ohgiraffers.section02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Application1 {
    public static void main(String[] args) {
        /* 입출력을 위한 길이 되는 스트림은 단방향이다.*/

        /* FileInputStream File로부터 데이터를 1바이트씩 읽어오는 스트림으로 파일로 부터 데이터를 읽어옴 */
        FileInputStream fin = null;
        // 여기서 null로 처리하지 않고 파일을 읽어오면서 생성하면 지역변수이기 때문에 파이널리 블록은
        // 존재를 알지 못하기 때문에 트라이 블럭 밖에서 해주고 있다.

        try {
            // 파일을 읽어오기 위한 길을 생성
            fin = new FileInputStream("src/com/ohgiraffers/section02/testInputStream.txt");

            int value; // 값을 읽어오는 변수선언

            // read() : 파일에 기록된 값을 1바이트씩 읽어온다. 더 이상 읽을 데이터가 없음녀 -1을 반환
            // 한글은 3바이트이기 때문에 읽어온 내용이 깨지게 된다.
            // 스트림으로 길을 열어주고 자원을 반납하기 위해 길을 닫아줘야 한다.
            while ((value = fin.read()) != -1) {

                System.out.println(value);

                System.out.println((char) value);  // 강제 형변환
            }

            System.out.println("파일의 길이 : " + new File("src/com/ohgiraffers/section02/testInputStream.txt").length());

            // 파일의 길이 만큼의 byte 배열을 만든다.
            int fileSize = (int) new File("src/com/ohgiraffers/section02/testInputStream.txt").length();
            byte[] bar = new byte[fileSize];

            // 파일의 내용을 읽어서 byte 배열에 기록해둔다.
            fin.read(bar);

            for(int i = 0; i < bar.length; i++) {
                System.out.println((char) bar[i]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {  // .read()에 대한 예외처리
            e.printStackTrace();
        } finally {
            // 사용이 끝난 스트림은 반드시 닫아줘야 한다.(자원 반납)
            if(fin !=null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    }
                }
            }


        }

    }

