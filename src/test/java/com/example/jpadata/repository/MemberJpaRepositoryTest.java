package com.example.jpadata.repository;

import com.example.jpadata.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class MemberJpaRepositoryTest {

    @Autowired
    MemberJpaRepository memberJpaRepository;


    @Test
    void basicCRUD() throws Exception{
        Member member1 = new Member("memberA");
        Member member2 = new Member("member2");
        memberJpaRepository.save(member1);
        memberJpaRepository.save(member2);

        Member findMember = memberJpaRepository.findById(member1.getId()).get();
        Member findMemberB = memberJpaRepository.findById(member2.getId()).get();

        assertThat(findMember).isEqualTo(member1);
        assertThat(findMemberB).isEqualTo(member2);

        // read list assertion
        List<Member> all = memberJpaRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

        // count assertion
        long count = memberJpaRepository.count();
        assertThat(count).isEqualTo(2);

        // delete assertion
        memberJpaRepository.delete(member1);
        memberJpaRepository.delete(member2);

        long deletedCount = memberJpaRepository.count();
        assertThat(deletedCount).isEqualTo(0);
    }
}
