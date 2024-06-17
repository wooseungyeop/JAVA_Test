package com.ohgiraffers.test.auth.impl;

import com.ohgiraffers.test.auth.SnsAuth;
import com.ohgiraffers.test.dto.MemberDTO;

public class GoogleAuth implements SnsAuth {

    @Override
    public boolean login(MemberDTO member) {
        System.out.println("구글 로그인 성공됨");
        return true;
    }
}
