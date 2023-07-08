package io.mongo.test.springmongo.domain.mongo.service.impl;

import io.mongo.test.springmongo.domain.mongo.entity.BoardsEntity;
import io.mongo.test.springmongo.domain.mongo.repository.BoardsRepository;
import io.mongo.test.springmongo.domain.mongo.service.SampleMongoService;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
//@AutoConfigureDataMongo
//@SpringBootTest
//@EnableAutoConfiguration
//@DirtiesContext

@ExtendWith(MockitoExtension.class)
//@DataMongoTest
//@EnableMongoRepositories(basePackageClasses = BoardsRepository.class)
//@ContextConfiguration(classes = {SampleMongoService.class})
public class SampleMongoServiceMongoTest {

    private SampleMongoService sampleMongoService;

    @Spy
    private BoardsRepository boardsRepository;


    @BeforeEach
    void setUp() {
        this.sampleMongoService = new SampleMongoServiceImpl(boardsRepository);
    }

//    @Test
//    public void 몽고_디비_값_추가() {
//        // givn
//        String name = "홍길동";
//        String body = "test";
//        String writer = "길동";
//
//        // when
//        BoardsEntity boards = boardsRepository.save(BoardsEntity.ofCreate(name, body, writer));
//
//        // then
//        assertEquals(boards.getName(), name);
//        assertEquals(boards.getBody(), body);
//        assertEquals(boards.getWriter(), writer);
//    }


    @Test
    public void 몽고_디비_값_추가_서비스() {
        // givn
        String name = "홍길동";
        String body = "test";
        String writer = "길동";

        final BoardsEntity board = BoardsEntity.builder()
                .name(name)
                .body(body)
                .writer(writer)
                .comments(List.of())
                .build();

        given(boardsRepository.save(board))
            .willReturn(BoardsEntity.builder()
                    .id(ObjectId.get())
                    .name(name)
                    .body(body)
                    .writer(writer)
                    .comments(List.of())
                    .build()
            );

        // when
        final BoardsEntity boards = sampleMongoService.insertBoard(board.getName(), board.getBody(), board.getWriter());

        // then
        assertEquals(boards.getName(), name);
        assertEquals(boards.getBody(), body);
        assertEquals(boards.getWriter(), writer);
    }
}
