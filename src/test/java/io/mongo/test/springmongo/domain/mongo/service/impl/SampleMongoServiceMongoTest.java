package io.mongo.test.springmongo.domain.mongo.service.impl;

import io.mongo.test.springmongo.domain.mongo.entity.BoardsEntity;
import io.mongo.test.springmongo.domain.mongo.repository.BoardsRepository;
import io.mongo.test.springmongo.domain.mongo.service.SampleMongoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@AutoConfigureDataMongo
//@SpringBootTest
//@EnableAutoConfiguration
//@DirtiesContext

@DataMongoTest
@EnableMongoRepositories(basePackageClasses = BoardsRepository.class)
@ContextConfiguration(classes = {SampleMongoService.class})
public class SampleMongoServiceMongoTest {

//    @Autowired
//    private SampleMongoService sampleMongoService;

    @Autowired
    private BoardsRepository boardsRepository;

    @Test
    public void 몽고_디비_값_추가() {
        // givn
        String name = "홍길동";
        String body = "test";
        String writer = "길동";

        // when
        BoardsEntity boards = boardsRepository.save(BoardsEntity.ofCreate(name, body, writer));

        // then
        assertEquals(boards.getName(), name);
        assertEquals(boards.getBody(), body);
        assertEquals(boards.getWriter(), writer);
    }


}
