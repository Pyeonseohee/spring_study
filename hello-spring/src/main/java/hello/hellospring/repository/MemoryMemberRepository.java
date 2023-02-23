package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //키값을 생성해 주는 애.
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null일 수 있으므로 optinal로 감싼다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // 없으면(null이면) optinal로 감싸져서 나옴.
    }

    @Override
    public List<Member> findAll() {
        // stoer에 있는 모든 Member값 list로 변환하여 반환.
        return new ArrayList<>(store.values());
    }
}
