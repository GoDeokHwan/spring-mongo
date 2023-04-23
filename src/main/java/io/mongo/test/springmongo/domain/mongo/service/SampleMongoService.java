package io.mongo.test.springmongo.domain.mongo.service;

import io.mongo.test.springmongo.domain.mongo.entity.BoardsEntity;

import java.util.List;

public interface SampleMongoService {
    void insertBoard(String name, String body, String writer);
    List<BoardsEntity> selectTitle(String name);
}
