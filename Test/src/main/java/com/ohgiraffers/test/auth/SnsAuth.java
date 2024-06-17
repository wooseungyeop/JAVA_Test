package com.ohgiraffers.test.auth;

import com.ohgiraffers.test.dto.MemberDTO;

public interface SnsAuth {
    boolean login(MemberDTO member);

}