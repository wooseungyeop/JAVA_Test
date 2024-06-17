package com.ohgiraffers.test.auth.impl;

import com.ohgiraffers.test.auth.SnsAuth;
import com.ohgiraffers.test.dto.MemberDTO;

public class NaverAuth implements SnsAuth {
    @Override
    public boolean login(MemberDTO member) {
        System.out.println("네이버 로그인됨");
        return true;
    }
}

