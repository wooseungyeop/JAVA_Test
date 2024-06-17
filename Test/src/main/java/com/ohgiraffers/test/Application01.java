package com.ohgiraffers.test;

import com.ohgiraffers.test.auth.impl.GoogleAuth;
import com.ohgiraffers.test.auth.impl.NaverAuth;
import com.ohgiraffers.test.auth.impl.KakaoAuth;
import com.ohgiraffers.test.dto.MemberDTO;
import com.ohgiraffers.test.service.MemberService;

import java.util.Scanner;

public class Application01 {

    public static void main(String[] args){
        MemberService memberService;
        Scanner scanner = new Scanner(System.in);
        do{
            MemberDTO memberDTO;

            System.out.println("----- 로그인 프로그램 시작 -----");
            System.out.println("1. google 로그인");
            System.out.println("2. naver 로그인");
            System.out.println("3. kakao 로그인");
            System.out.println("9. 프로그램 종료");
            System.out.println("로그인 할 인증 수단을 선택해주세요");
            int choice = scanner.nextInt();

            scanner.nextLine();  // 개행 문자 처리
            System.out.print("아이디를 입력해주세요: ");
            String id = scanner.nextLine();
            System.out.print("비밀번호를 입력해주세요: ");
            String pwd = scanner.nextLine();
            // 위에서 선언한 memberDTO를 초기화 해줌
            memberDTO = new MemberDTO(id, pwd);
            String result = "";

            switch (choice){
                case 1 :
                    memberService = new MemberService(new GoogleAuth());
                    result = memberService.findMember(memberDTO);
                    if("success".equals(result)){  // 로그인 성공 문자열 비교
                        System.out.println("google 로그인에 성공하였습니다. " + memberDTO.getId());
                    } else {
                        System.out.println("google 로그인에 실패하였습니다.");
                    }
                    break;

                case 2 :
                    memberService = new MemberService(new NaverAuth());
                    result = memberService.findMember(memberDTO);
                    if("success".equals(result)){  // 로그인 성공 문자열 비교
                        System.out.println("naver 로그인에 성공하였습니다. " + memberDTO.getId());
                    } else {
                        System.out.println("naver 로그인에 실패하였습니다.");
                    }
                    break;

                case 3 :
                    memberService = new MemberService(new KakaoAuth());
                    result = memberService.findMember(memberDTO);
                    if("success".equals(result)){  // 로그인 성공 문자열 비교
                        System.out.println("kakao 로그인에 성공하였습니다. " + memberDTO.getId());
                    } else {
                        System.out.println("kakao 로그인에 실패하였습니다.");
                    }
                    break;

                case 9 :
                    System.out.println("로그인을 종료합니다.");
                    return;

                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        } while (true);
    }
}
