package com.ohgiraffers.section02;

import java.io.FileWriter;
import java.io.IOException;

public class Application4 {
    public static void main(String[] args) {
        /* FileWriter : 프로그램의 데이터를 1글자 단위로 파일로 내보내기 위한 스트림
        *  주요 대상 : 모든 종류의 파일(이미지, 영상, 텍스트 등)을 다룰 수 있다.
        *  */

        try(FileWriter fw = new FileWriter("src/com/ohgiraffers/section02/testWriter.txt")) {

            fw.write(97);

            fw.write('A');

            fw.write(new char[]{'a', 'b','c','d'});

            fw.write("안녕하세요 반가워요!");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
