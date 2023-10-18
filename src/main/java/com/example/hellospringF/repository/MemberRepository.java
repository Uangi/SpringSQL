package com.example.hellospringF.repository;

import com.example.hellospringF.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 저장소에서 저장
    Optional<Member> findById(Long id); // Member 요소의 Id만 불러오기
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 저장된 모든 회원 리스트 반환

}
/* 저장소에 단순히 값만 넣어뒀다가 빼줬다가 하는 느낌 */
