package io.mongo.test.springmongo.domain.mongo.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Document(collection = "boards")
public class BoardsEntity {
    @MongoId
    private ObjectId id;
    private String name;
    private List<CommentEntity> comments = new ArrayList<>();
    private String body;
    private String writer;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    public static BoardsEntity ofCreate(String name, String body, String writer) {
        BoardsEntity instance = new BoardsEntity();
        instance.name = name;
        instance.body = body;
        instance.writer = writer;
        instance.createDate = LocalDateTime.now();
        instance.modifyDate = LocalDateTime.now();
        return instance;
    }

}
