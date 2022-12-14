package com.example.jpadata.repository;

import com.example.jpadata.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void findMember() throws Exception {
        Member member = new Member("memberA");
        Member savedMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(savedMember.getId()).get();

        Assertions.assertThat(savedMember.getId()).isEqualTo(findMember.getId());
        Assertions.assertThat(savedMember.getUsername()).isEqualTo(findMember.getUsername());
    }


    @Test
    void basicCRUD() throws Exception{
        Member member1 = new Member("memberA");
        Member member2 = new Member("member2");
        memberRepository.save(member1);
        memberRepository.save(member2);

        Member findMember = memberRepository.findById(member1.getId()).get();
        Member findMemberB = memberRepository.findById(member2.getId()).get();

        assertThat(findMember).isEqualTo(member1);
        assertThat(findMemberB).isEqualTo(member2);

        // read list assertion
        List<Member> all = memberRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

        // count assertion
        long count = memberRepository.count();
        assertThat(count).isEqualTo(2);

        // delete assertion
        memberRepository.delete(member1);
        memberRepository.delete(member2);

        long deletedCount = memberRepository.count();
        assertThat(deletedCount).isEqualTo(0);
    }

}