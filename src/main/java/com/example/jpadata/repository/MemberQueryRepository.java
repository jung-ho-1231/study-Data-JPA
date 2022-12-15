package com.example.jpadata.repository;

import com.example.jpadata.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberQueryRepository {

    private final EntityManager em;

    List<Member> findAllList() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
