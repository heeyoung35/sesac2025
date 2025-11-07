package com.ohgiraffers.section03.filterstream;

import com.ohgiraffers.section03.filterstream.dto.MemberDTO;

import java.io.*;

public class Application4 {
    public static void main(String[] args) {

        /* 객체단위 입출력 보조스트림 (objectOutputStream/ objectInputStream) 객체를 통째로 파일로 저장하고 통째로 읽어옴 */

        MemberDTO[] outputMembers = {
                new MemberDTO("user01", "pass01", "홍길동" , 25, 1250.7),
                new MemberDTO("user02", "pass02", "이순신" , 49, 1000.7),
                new MemberDTO("user03", "pass03", "유관순" , 15, 1400.7),
        };

        try(ObjectOutputStream obuOut = new ObjectOutputStream(new FileOutputStream("src/com/ohgiraffers/section03/filterstream/testObjectStream.txt"))) {

            for(MemberDTO mem : outputMembers) {
                obuOut.writeObject(mem);  // writeObject로 객체를 통째로 쓴다.
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("src/com/ohgiraffers/section03/filterstream/testObjectStream.txt"))) {

            while (true) {
                System.out.println((MemberDTO)objIn.readObject());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            // 파일 읽기가 끝난 시점에 파일 끝에 도달했다"는 신호로 EOFException을 의도적으로 발생시키고 이것에 대한 예외처리
            System.out.println("파일 읽기를 완료했습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
