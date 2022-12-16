package com.example.jpadata.repository;

import com.example.jpadata.entity.Item;
import com.example.jpadata.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
