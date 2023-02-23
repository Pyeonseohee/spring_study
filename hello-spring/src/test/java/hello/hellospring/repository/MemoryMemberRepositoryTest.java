package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {
    MemberRepository repository= new MemoryMemberRepository();

    // test케이스 생성
    @Test
    public void save(){
        Member member = new Member();
        member.setName("Pyeon");

        repository.save(member);
        // optional에서 값을 꺼낼때는 뒤에 .get()을 붙여줘야 함.
        Member result = repository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));
        Assertions.assertEquals(member, result); // 일치하면 콘솔창에 아무것도 안뜸.
        Assertions.assertEquals(result, null); // 불일치하면 콘솔창에 기댓값과 실젯값이 비교돼서 출력됨.
    }
}
