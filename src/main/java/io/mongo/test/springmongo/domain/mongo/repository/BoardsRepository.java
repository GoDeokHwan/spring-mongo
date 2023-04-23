package io.mongo.test.springmongo.domain.mongo.repository;

import io.mongo.test.springmongo.domain.mongo.entity.BoardsEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface BoardsRepository extends MongoRepository<BoardsEntity, ObjectId> {

    @Query("{ name: /?0/ }")
    List<BoardsEntity> findAllByNameLike(String title);
}
