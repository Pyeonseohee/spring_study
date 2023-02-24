package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository= new MemoryMemberRepository();

    // 테스트 메서드가 하나하나 끝날때마다 동작하는 것.
    // 테스트 케이스가 끝나면 refresh해줘야함.
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    // test케이스 생성
    @Test
    public void save(){
        Member member = new Member();
        member.setName("Pyeon");

        repository.save(member);
        // optional에서 값을 꺼낼때는 뒤에 .get()을 붙여줘야 함.
        Member result = repository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));
        //Assertions.assertEquals(member, result); // 일치하면 콘솔창에 아무것도 안뜸.
        //Assertions.assertEquals(result, null); // 불일치하면 콘솔창에 기댓값과 실젯값이 비교돼서 출력됨.
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("Yongcha");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spyeon");
        repository.save(member2);

        Member result = repository.findByName("Yongcha").get();
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(member1);
    }
    
    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2); // 새로운 변수명 다 바꿀때 단축키 shift + F6

        List<Member> result = repository.findAll();
        Assertions.assertEquals(result.size(), 2);
    }
}
