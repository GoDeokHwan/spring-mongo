package io.mongo.test.springmongo.domain.mongo.service.impl;

import io.mongo.test.springmongo.domain.mongo.entity.BoardsEntity;
import io.mongo.test.springmongo.domain.mongo.service.SampleMongoService;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Book;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class SampleMongoServiceTest {

    @Autowired
    private SampleMongoService service;
    @Test
    public void 게시판_저장() {
        Faker faker = new Faker(Locale.KOREAN);
        StopWatch watch = new StopWatch("Watch");

        watch.start("Insert");
        Book book  = faker.book();
        service.insertBoard(book.title(), book.publisher(), book.author());
        watch.stop();

        watch.start("Insert 100");
        for (int i = 0; i < 100; i++) {
            Book book2  = faker.book();
            service.insertBoard(book2.title(), book2.publisher(), book2.author());
        }
        watch.stop();

        watch.start("Insert 10000");
        for (int i = 0; i < 10000; i++) {
            Book book2  = faker.book();
            service.insertBoard(book2.title(), book2.publisher(), book2.author());
        }
        watch.stop();

        System.out.println(watch.prettyPrint());
        System.out.println(watch.toString());
    }

    @Test
    void 타이틀_조회() {
        List<BoardsEntity> list = service.selectTitle("the");
        System.out.println(list.size());
    }


}