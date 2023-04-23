package io.mongo.test.springmongo.domain.mongo.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CommentEntity {
    private ObjectId id;
    private String body;
    private List<CommentEntity> comments;
    private String writer;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
}
