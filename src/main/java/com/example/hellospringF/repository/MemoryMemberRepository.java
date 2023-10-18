package com.example.hellospringF.repository;

import com.example.hellospringF.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;  // 키 값 생성
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  // null 값이 들어와도 optional로 감싸서 반환해줄 수 있음
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()  // 람다 - 파라미터로 넘어온 이름과 같다면 필터링
                .filter(member -> member.getName().equals(name))
                .findAny(); // , 그중에서 하나라도 찾으면 반환, 없다면 optionalNull


    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
