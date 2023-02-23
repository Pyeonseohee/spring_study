package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import java.util.Optional;
import java.util.List;

public interface MemberRepository {
    Member save(Member member); // 멤버 등록 기능
    // optional은 findById나 Name을 했을시 null값이 나올 수 있는데, 이 null값을 optinal로 감싸서 처리해줌.
    Optional<Member> findById(Long id); // id로 조회
    Optional<Member> findByName(String name); // 이름으로 조회

    List<Member> findAll(); // 모든 회원 list 반환
}
