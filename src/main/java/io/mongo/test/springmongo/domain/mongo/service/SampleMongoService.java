package io.mongo.test.springmongo.domain.mongo.service;

import io.mongo.test.springmongo.domain.mongo.entity.BoardsEntity;

import java.util.List;

public interface SampleMongoService {
    BoardsEntity insertBoard(String name, String body, String writer);
    List<BoardsEntity> selectTitle(String name);
}
