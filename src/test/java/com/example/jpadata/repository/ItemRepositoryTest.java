package com.example.jpadata.repository;

import com.example.jpadata.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @Test
    void save() throws Exception {
        // create new item
        Item item = new Item("A");
        // save item
        itemRepository.save(item);
    }


}