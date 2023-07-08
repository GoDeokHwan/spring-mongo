package io.mongo.test.springmongo.domain.mongo.service.impl;

import io.mongo.test.springmongo.domain.mongo.entity.BoardsEntity;
import io.mongo.test.springmongo.domain.mongo.repository.BoardsRepository;
import io.mongo.test.springmongo.domain.mongo.service.SampleMongoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
@RequiredArgsConstructor
public class SampleMongoServiceImpl implements SampleMongoService {

    private final BoardsRepository boardsRepository;
//    private final MongoTemplate mongoTemplate;
    @Override
    public BoardsEntity insertBoard(String name, String body, String writer) {
        BoardsEntity boards = BoardsEntity.ofCreate(name, body, writer);
        ReflectionU
        return boardsRepository.save(boards);
    }

    @Override
    public List<BoardsEntity> selectTitle(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(name));
//        return mongoTemplate.find(query, BoardsEntity.class);
        return boardsRepository.findByNameLike(name);
    }


}
