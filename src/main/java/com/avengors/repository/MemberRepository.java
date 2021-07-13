package com.avengors.repository;

import com.avengors.entity.Member;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

public interface MemberRepository {
    int save(Member member);

    @Select("SELECT * FROM MEMBER m WHERE m.USERID = #{userId}")
    Optional<Member> findByUserId(String userId);

    @Select("SELECT * FROM MEMBER m WHERE m.USERID = #{userId} AND m.USERPW = #{userPw}")
    Optional<Member> findByUserIdAndUserPw(@Param("userId") String userId, @Param("userPw") String userPw);
}
