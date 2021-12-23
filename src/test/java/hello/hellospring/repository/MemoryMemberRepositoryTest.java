package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("hello spring");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("2donny");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("5donny");
        repository.save(member2);

        Member result = repository.findByName("2donny").get();
        assertThat(member1).isEqualTo(result);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("hello");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("world");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
